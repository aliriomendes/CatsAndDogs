package com.aliriomendes.catsanddogs;

import android.app.Activity;
import android.app.Application;

import com.aliriomendes.catsanddogs.di.AppModule;
import com.aliriomendes.catsanddogs.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by aliriomendes on 15/02/2018.
 */

public class CatsAndDogsApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
