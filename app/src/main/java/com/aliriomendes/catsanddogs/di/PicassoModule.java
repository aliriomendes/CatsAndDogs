package com.aliriomendes.catsanddogs.di;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by aliriomendes on 15/02/2018.
 */

@Module(includes = { ContextModule.class, NetworkModule.class})
public class PicassoModule {
    @Provides
    @CatsAndDogsApplicationScope
    public Picasso picasso(Context context, OkHttp3Downloader okHttp3Downloader){
        return new Picasso.Builder(context).downloader(okHttp3Downloader).build();
    }
    @Provides
    @CatsAndDogsApplicationScope
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }
}
