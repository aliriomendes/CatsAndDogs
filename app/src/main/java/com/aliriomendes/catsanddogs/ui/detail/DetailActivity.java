package com.aliriomendes.catsanddogs.ui.detail;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.aliriomendes.catsanddogs.R;
import com.aliriomendes.catsanddogs.data.entities.FeedItem;
import com.aliriomendes.catsanddogs.ui.base.BaseActivity;
import com.aliriomendes.catsanddogs.ui.main.MainViewModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity {

    @BindView(R.id.photo_imageView)
    ImageView imageView;

    private FeedItem feedItem;

    private DetailViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewModel = ViewModelProviders.of(this, getViewModelFactory()).get(DetailViewModel.class);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
            feedItem = getIntent().getParcelableExtra(getString(R.string.feed_item_key));

        getSupportActionBar().setTitle(feedItem.getTitle());
        Picasso.with(this).load(feedItem.getMedia().getImage()).into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
            case R.id.share_action:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
