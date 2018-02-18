package com.aliriomendes.catsanddogs.ui.main;

import android.view.View;

import com.aliriomendes.catsanddogs.data.entities.FeedItem;

/**
 * Created by aliriomendes on 17/02/2018.
 */

public interface FeedItemListCallback {
    void onItemClicked(FeedItem feedItem, View sharedView);
}
