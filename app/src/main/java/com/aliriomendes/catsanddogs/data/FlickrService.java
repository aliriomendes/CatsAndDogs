package com.aliriomendes.catsanddogs.data;

import com.aliriomendes.catsanddogs.data.entities.Feed;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aliriomendes on 15/02/2018.
 */

public interface FlickrService {
    @GET(ApiConstants.ENDPOINT_FEED)
    Call<Feed> loadFeed();
}
