package com.aliriomendes.catsanddogs.di;

import com.aliriomendes.catsanddogs.data.ApiConstants;
import com.aliriomendes.catsanddogs.data.FlickrService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aliriomendes on 15/02/2018.
 */
@Module(includes = NetworkModule.class)
public class FlickrServiceModule {
    @Provides
    @CatsAndDogsApplicationScope
    public FlickrService flickrService(Retrofit retrofit){
        return retrofit.create(FlickrService.class);
    }

    @Provides
    @CatsAndDogsApplicationScope
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @CatsAndDogsApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .baseUrl(ApiConstants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }
}
