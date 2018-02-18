package com.aliriomendes.catsanddogs.di;

import com.aliriomendes.catsanddogs.ui.detail.DetailActivity;
import com.aliriomendes.catsanddogs.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
/**
 * Created by aliriomendes on 16/02/2018.
 */
@Module(includes = ViewModelModule.class)
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivityInjector();

    @ContributesAndroidInjector
    abstract DetailActivity contributeDetailActivityInjector();
}
