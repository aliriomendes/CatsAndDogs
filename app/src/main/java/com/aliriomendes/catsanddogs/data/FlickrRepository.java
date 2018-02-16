package com.aliriomendes.catsanddogs.data;

import android.support.annotation.WorkerThread;
import android.util.Log;

import com.aliriomendes.catsanddogs.data.entities.Feed;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aliriomendes on 15/02/2018.
 */
@Singleton
public class FlickrRepository {
    private final String TAG = "FlickrRepository";
    private final FlickrService flickrService;

    @Inject
    public FlickrRepository(FlickrService flickrService) {
        this.flickrService = flickrService;
    }
    @WorkerThread
    public void loadFeed(Callback<Feed> feedDataObserver){
       flickrService.loadFeed().enqueue(feedDataObserver);
    }
}
