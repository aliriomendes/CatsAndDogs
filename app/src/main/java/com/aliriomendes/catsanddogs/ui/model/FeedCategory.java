package com.aliriomendes.catsanddogs.ui.model;

import com.aliriomendes.catsanddogs.data.entities.FeedItem;

import java.util.List;

/**
 * Created by aliriomendes on 17/02/2018.
 */

public class FeedCategory {
    private FeedCategoryType type;
    private List<FeedItem> feedItems;



    public FeedCategory(FeedCategoryType type, List<FeedItem> feedItems) {
        this.type = type;
        this.feedItems = feedItems;
    }

    public FeedCategoryType getType() {
        return type;
    }

    public List<FeedItem> getFeedItems() {
        return feedItems;
    }

    public void setFeedItems(List<FeedItem> feedItems) {
        this.feedItems = feedItems;
    }
}

