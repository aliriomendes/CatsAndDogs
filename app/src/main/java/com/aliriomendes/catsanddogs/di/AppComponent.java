package com.aliriomendes.catsanddogs.di;

import com.aliriomendes.catsanddogs.CatsAndDogsApplication;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by aliriomendes on 15/02/2018.
 */
@Singleton
@Component(modules = { FlickrServiceModule.class, PicassoModule.class, AppModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<AppComponent> {
    Picasso getPicasso();
    @Component.Builder
    interface Builder {
        Builder appModule(AppModule appModule);
        AppComponent build();
    }

    void inject(CatsAndDogsApplication application);
}
