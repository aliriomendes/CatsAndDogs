package com.aliriomendes.catsanddogs.data;

import com.aliriomendes.catsanddogs.data.entities.Feed;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aliriomendes on 15/02/2018.
 */

public interface FlickrService {
    @GET("services/feeds/photos_public.gne?lang=en-us&format=json&nojsoncallback=1")
    Call<Feed> loadFeed();
}
