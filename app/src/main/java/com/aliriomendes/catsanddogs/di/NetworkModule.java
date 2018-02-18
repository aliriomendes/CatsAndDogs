package com.aliriomendes.catsanddogs.di;

import android.content.Context;


import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by aliriomendes on 15/02/2018.
 */
@Module(includes = { AppModule.class})
public class NetworkModule {
    @Provides
    @Singleton
    public Cache cache(File file){
        return new Cache(file,10 * 1000 * 1000);
    }

    @Provides
    @Singleton
    public File file(Context context){
        return new File(context.getCacheDir(), "okHttp_cache");
    }

    @Provides
    @Singleton
    public OkHttpClient okHttpClient(Cache cache){
        return new OkHttpClient.Builder().cache(cache).build();
    }
}
