package com.aliriomendes.catsanddogs.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by aliriomendes on 15/02/2018.
 */
@Module
public class ContextModule {
    private final Context context;
    public ContextModule(Context context) {
        this.context = context;
    }
    @Provides
    @CatsAndDogsApplicationScope
    public Context context(){
        return this.context;
    }
}
