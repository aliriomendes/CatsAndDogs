package com.aliriomendes.catsanddogs;

import android.app.Application;

import com.aliriomendes.catsanddogs.data.FlickrService;
import com.aliriomendes.catsanddogs.data.entities.Feed;
import com.aliriomendes.catsanddogs.di.CatsAndDogsAppComponent;
import com.aliriomendes.catsanddogs.di.ContextModule;
import com.aliriomendes.catsanddogs.di.DaggerCatsAndDogsAppComponent;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by aliriomendes on 15/02/2018.
 */

public class CatsAndDogsApplication extends Application {
    private Picasso picasso;
    private FlickrService flickrService;
    @Override
    public void onCreate() {
        super.onCreate();
        CatsAndDogsAppComponent component = DaggerCatsAndDogsAppComponent.builder().contextModule(new ContextModule(this)).build();

        picasso = component.getPicasso();
        flickrService = component.getFlickrService();

    }

    public Picasso getPicasso() {
        return picasso;
    }

    public FlickrService getFlickrService() {
        return flickrService;
    }
}
