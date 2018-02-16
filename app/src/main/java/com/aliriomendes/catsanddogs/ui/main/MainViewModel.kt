package com.aliriomendes.catsanddogs.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.aliriomendes.catsanddogs.data.FlickrRepository
import com.aliriomendes.catsanddogs.data.entities.Feed
import com.aliriomendes.catsanddogs.data.entities.FeedItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by aliriomendes on 15/02/2018.
 */

class MainViewModel @Inject
constructor(private val flickrRepository: FlickrRepository) : ViewModel() {
    private val TAG = "MainViewModel"
    val dogListLiveData = MutableLiveData<List<FeedItem>>()
    val catListLiveData = MutableLiveData<List<FeedItem>>()
    val publicFeedLiveData = MutableLiveData<List<FeedItem>>()

    private val feedDataObserver = object : Callback<Feed> {
        override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
            setData(response.body())
        }

        override fun onFailure(call: Call<Feed>, t: Throwable) {
            Log.w(TAG, "Failed to get feed!!!")
        }
    }

    fun loadFeed() {
        this.flickrRepository.loadFeed(feedDataObserver)
    }

    private fun setData(feed: Feed) {
        dogListLiveData.value = feed.items.filter { it.tags.contains("cat")}
        catListLiveData.value = feed.items.filter { it.tags.contains("dog")}
        publicFeedLiveData.value = feed.items
        feed.items.forEach {
            Log.d(TAG, it.author.toString())
        }

    }
}
