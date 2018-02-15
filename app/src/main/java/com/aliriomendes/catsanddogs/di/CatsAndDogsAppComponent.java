package com.aliriomendes.catsanddogs.di;

import com.aliriomendes.catsanddogs.data.FlickrService;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by aliriomendes on 15/02/2018.
 */
@CatsAndDogsApplicationScope
@Component(modules = { FlickrServiceModule.class, PicassoModule.class })
public interface CatsAndDogsAppComponent {
    FlickrService getFlickrService();
    Picasso getPicasso();
}
