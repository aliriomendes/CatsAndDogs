package com.aliriomendes.catsanddogs.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.util.Log;

import com.aliriomendes.catsanddogs.CatsAndDogsApplication;
import com.aliriomendes.catsanddogs.R;
import com.aliriomendes.catsanddogs.data.entities.Feed;
import com.aliriomendes.catsanddogs.ui.base.BaseActivity;
import com.aliriomendes.catsanddogs.viewmodels.MainViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
    private final String TAG = "MainActivity";
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        Call<Feed> feedCall = ((CatsAndDogsApplication)getApplication()).getFlickrService().loadFeed();
        feedCall.enqueue(feedDataObserver);
    }

    private final Callback<Feed> feedDataObserver = new Callback<Feed>() {
        @Override
        public void onResponse(Call<Feed> call, Response<Feed> response) {
            Feed feed = response.body();
            Log.d(TAG,feed.toString());
        }

        @Override
        public void onFailure(Call<Feed> call, Throwable t) {

        }
    };
}
