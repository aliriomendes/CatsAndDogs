package com.aliriomendes.catsanddogs.ui.detail;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.aliriomendes.catsanddogs.R;
import com.aliriomendes.catsanddogs.data.entities.FeedItem;
import com.aliriomendes.catsanddogs.ui.base.BaseActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
                shareLink();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareLink(){
        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, feedItem.getTitle());
            intent.putExtra(Intent.EXTRA_TEXT, feedItem.getLink());
            startActivity(Intent.createChooser(intent, "Share URL"));
        }catch (Exception ex){
            Toast.makeText(this, R.string.share_link_error_message, Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.go_button)
    public void goButtonClick(View view) {
        try {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(feedItem.getLink()));
            startActivity(browserIntent);
        }catch (Exception ex){
            Toast.makeText(this, R.string.open_link_error_message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
