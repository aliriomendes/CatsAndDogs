package com.aliriomendes.catsanddogs.data;

import com.aliriomendes.catsanddogs.data.entities.Feed;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Callback;

/**
 * Created by aliriomendes on 15/02/2018.
 */
@Singleton
public class FlickrRepository {
    private final FlickrService flickrService;

    @Inject
    public FlickrRepository(FlickrService flickrService) {
        this.flickrService = flickrService;
    }

    public void loadPublicFeed(Callback<Feed> feedDataObserver){
       flickrService.loadPublicFeed().enqueue(feedDataObserver);
    }

    public void loadCats(Callback<Feed> feedDataObserver){
        flickrService.loadCatsFeed().enqueue(feedDataObserver);
    }

    public void loadDogs(Callback<Feed> feedDataObserver){
        flickrService.loadDogsFeed().enqueue(feedDataObserver);
    }
}
