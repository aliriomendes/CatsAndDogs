package com.aliriomendes.catsanddogs.ui.main;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.aliriomendes.catsanddogs.R;
import com.aliriomendes.catsanddogs.data.entities.FeedItem;
import com.aliriomendes.catsanddogs.ui.base.BaseActivity;
import com.aliriomendes.catsanddogs.ui.detail.DetailActivity;
import com.aliriomendes.catsanddogs.ui.model.FeedCategory;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements LifecycleOwner, FeedItemListCallback {

    @Inject
    FeedCategoryAdapter feedCategoryAdapter;

    @BindView(R.id.feed_recyclerView)
    RecyclerView feedCategoryRecyclerView;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(R.string.ki_labs);
        feedCategoryRecyclerView.setAdapter(feedCategoryAdapter);
        feedCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = ViewModelProviders.of(this, getViewModelFactory()).get(MainViewModel.class);
        viewModel.getFeedCategoriesLiveData().observe(this, observer);
        viewModel.loadFeed();
    }

    private final Observer<List<FeedCategory>> observer = feedCategoryList -> feedCategoryAdapter.setData(feedCategoryList);

    @Override
    public void onItemClicked(FeedItem feedItem, View sharedView) {
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, sharedView, getString(R.string.shared_image));

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(getString(R.string.feed_item_key), feedItem);
        startActivity(intent, options.toBundle());
    }
}
