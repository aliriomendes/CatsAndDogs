package com.aliriomendes.catsanddogs.ui.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aliriomendes.catsanddogs.R;
import com.aliriomendes.catsanddogs.ui.base.BaseAdapter;
import com.aliriomendes.catsanddogs.ui.model.FeedCategory;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.Nullable;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aliriomendes on 17/02/2018.
 */

public class FeedCategoryAdapter extends BaseAdapter<FeedCategoryAdapter.FeedCategoryViewHolder, FeedCategory> {
    @Inject
    Picasso picasso;

    private final FeedItemListCallback movieListCallback;
    private List<FeedCategory> feedCategories;

    @Inject
    public FeedCategoryAdapter(MainActivity mainActivity) {
        this.movieListCallback = mainActivity;
    }

    @Override
    public FeedCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.feed_category_item, parent, false);
        return new FeedCategoryViewHolder(view, movieListCallback);
    }

    @Override
    public void onBindViewHolder(FeedCategoryViewHolder holder, int position) {
        holder.updateView(feedCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return feedCategories == null ? 0 : feedCategories.size();
    }

    @Override
    public void setData(List<FeedCategory> feedCategories) {
        this.feedCategories = feedCategories;
        this.notifyDataSetChanged();
    }

    class FeedCategoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.feed_recyclerView) RecyclerView recyclerView;
        @BindView(R.id.category_textView) TextView title;
        private FeedItemAdapter feedItemAdapter;

        FeedCategoryViewHolder(View itemView, FeedItemListCallback movieListCallback) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            feedItemAdapter = new FeedItemAdapter(movieListCallback);
            recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setAdapter(feedItemAdapter);
        }

        void updateView(FeedCategory feedCategory) {
            title.setText(feedCategory.getType().toString());
            feedItemAdapter.setData(feedCategory.getFeedItems());
        }
    }
}
