package com.aliriomendes.catsanddogs.ui.main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aliriomendes.catsanddogs.R;
import com.aliriomendes.catsanddogs.data.entities.FeedItem;
import com.aliriomendes.catsanddogs.ui.base.BaseAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by aliriomendes on 17/02/2018.
 */

public class FeedItemAdapter extends BaseAdapter<FeedItemAdapter.FeedItemViewHolder, FeedItem> {
    private List<FeedItem> feedItems;
    private FeedItemListCallback itemListCallback;

    public FeedItemAdapter(FeedItemListCallback itemListCallback) {
        this.itemListCallback = itemListCallback;
    }

    @Override
    public FeedItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.photo_item, parent, false);
        return new FeedItemViewHolder(view, itemListCallback);
    }

    @Override
    public void onBindViewHolder(FeedItemViewHolder holder, int position) {

        holder.updateView(feedItems.get(position));
    }

    @Override
    public int getItemCount() {
        return feedItems == null ? 0 : feedItems.size();
    }

    @Override
    public void setData(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
        this.notifyDataSetChanged();
    }

    class FeedItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.photo_imageView) ImageView imageView;
        @BindView(R.id.title_textView) TextView title;

        private FeedItem feedItem;

        FeedItemViewHolder(View itemView,FeedItemListCallback itemListCallback) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> itemListCallback.onItemClicked(feedItem, imageView));
        }

        void updateView(FeedItem feedItem) {
            this.feedItem = feedItem;
            Picasso.with(itemView.getContext()).load(feedItem.getMedia().getM()).into(imageView);
            title.setText(feedItem.getTitle());
        }
    }
}
