package com.aliriomendes.catsanddogs;

import com.aliriomendes.catsanddogs.data.FlickrService;
import com.aliriomendes.catsanddogs.data.entities.Feed;
import com.aliriomendes.catsanddogs.data.entities.FeedItem;
import com.aliriomendes.catsanddogs.data.entities.Media;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import okio.BufferedSource;
import okio.Okio;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

/**
 * Created by aliriomendes on 18/02/2018.
 */

public class FlickrServiceTest {
    private FlickrService flickrService;
    private MockWebServer mockWebServer;

    @Before
    public void createService() throws IOException {
        mockWebServer = new MockWebServer();
        flickrService = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .build()
                .create(FlickrService.class);
    }

    @After
    public void stopService() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void getPublicFeed() throws IOException, InterruptedException {
        enqueueResponse("public_feed_data.json");
        Call<Feed> call = flickrService.loadPublicFeed();
        Feed feed = call.execute().body();
        RecordedRequest request = mockWebServer.takeRequest();

        Assert.assertThat(request.getPath(), is("/services/feeds/photos_public.gne?lang=en-us&format=json&nojsoncallback=1"));

        Assert.assertThat(feed.getItems().size(), is(20));

        FeedItem feedItem = feed.getItems().get(0);
        Assert.assertThat(feedItem.getAuthor(), is("nobody@flickr.com (\"The Inspired Idea\")"));

        Media media = feedItem.getMedia();
        Assert.assertThat(media, notNullValue());
        Assert.assertThat(media.getImage(), is("http://farm5.staticflickr.com/4667/25473490007_34a2a8d1ee_m.jpg"));
    }

    private void enqueueResponse(String fileName) throws IOException {
        enqueueResponse(fileName, Collections.emptyMap());
    }

    private void enqueueResponse(String fileName, Map<String, String> headers) throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("api-response/" + fileName);
        BufferedSource source = Okio.buffer(Okio.source(inputStream));
        MockResponse mockResponse = new MockResponse();
        for (Map.Entry<String, String> header : headers.entrySet()) {
            mockResponse.addHeader(header.getKey(), header.getValue());
        }
        mockWebServer.enqueue(mockResponse.setBody(source.readString(StandardCharsets.UTF_8)));
    }
}