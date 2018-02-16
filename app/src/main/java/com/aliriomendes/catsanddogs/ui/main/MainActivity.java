package com.aliriomendes.catsanddogs.ui.main;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.aliriomendes.catsanddogs.R;
import com.aliriomendes.catsanddogs.data.entities.FeedItem;
import com.aliriomendes.catsanddogs.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements LifecycleOwner {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private final String TAG = "MainActivity";

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        viewModel.getDogListLiveData().observe(this, dogListObserver);
        viewModel.getCatListLiveData().observe(this, catListObserver);
        viewModel.getPublicFeedLiveData().observe(this, publicFeedObserver);

        viewModel.loadFeed();
    }

    private final Observer<List<FeedItem>> dogListObserver = new Observer<List<FeedItem>>(){

        @Override
        public void onChanged(@Nullable List<FeedItem> feedItems) {
            Log.d(TAG,String.valueOf(feedItems.size()));
        }
    };
    private final Observer<List<FeedItem>> catListObserver = new Observer<List<FeedItem>>(){

        @Override
        public void onChanged(@Nullable List<FeedItem> feedItems) {
            Log.d(TAG,String.valueOf(feedItems.size()));
        }
    };
    private final Observer<List<FeedItem>> publicFeedObserver = new Observer<List<FeedItem>>(){

        @Override
        public void onChanged(@Nullable List<FeedItem> feedItems) {
            Log.d(TAG,String.valueOf(feedItems.size()));
        }
    };
}
