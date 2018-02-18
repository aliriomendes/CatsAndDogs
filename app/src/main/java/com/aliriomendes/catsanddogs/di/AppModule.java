package com.aliriomendes.catsanddogs.di;

import android.content.Context;

import com.aliriomendes.catsanddogs.CatsAndDogsApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aliriomendes on 15/02/2018.
 */
@Module(includes = { ViewModelModule.class, ActivityBuilderModule.class})
public class AppModule {
    private CatsAndDogsApplication application;

    public AppModule(CatsAndDogsApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public CatsAndDogsApplication application() {
        return this.application;
    }

    @Provides
    @Singleton
    public Context context(){
        return this.application;
    }
}
