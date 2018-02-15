package com.aliriomendes.catsanddogs.di;

import android.content.Context;


import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by aliriomendes on 15/02/2018.
 */
@Module(includes = { ContextModule.class})
public class NetworkModule {
    @Provides
    @CatsAndDogsApplicationScope
    public Cache cache(File file){
        return new Cache(file,10 * 1000 * 1000);
    }
    @Provides
    @CatsAndDogsApplicationScope
    public File file(Context context){
        return new File(context.getCacheDir(), "okHttp_cache");
    }
    @Provides
    @CatsAndDogsApplicationScope
    public OkHttpClient okHttpClient(Cache cache){
        return new OkHttpClient.Builder().cache(cache).build();
    }
}
