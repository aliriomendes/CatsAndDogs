package com.aliriomendes.catsanddogs.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.aliriomendes.catsanddogs.data.FlickrRepository
import com.aliriomendes.catsanddogs.data.entities.Feed
import com.aliriomendes.catsanddogs.data.entities.FeedItem
import com.aliriomendes.catsanddogs.ui.model.FeedCategory
import com.aliriomendes.catsanddogs.ui.model.FeedCategoryType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by aliriomendes on 15/02/2018.
 */

class MainViewModel @Inject
constructor(private val flickrRepository: FlickrRepository) : ViewModel() {
    private val TAG:String = "MainViewModel"
    private val CATS_POSITION = 0
    private val DOGS_POSITION = 1
    private val PUBLIC_FEED_POSITION = 2

    val categoryList: MutableList<FeedCategory> = mutableListOf()
    val feedCategoriesLiveData = MutableLiveData<List<FeedCategory>>()
    init {
        categoryList.add(CATS_POSITION, FeedCategory(FeedCategoryType.CATS, null))
        categoryList.add(DOGS_POSITION, FeedCategory(FeedCategoryType.DOGS, null))
        categoryList.add(PUBLIC_FEED_POSITION, FeedCategory(FeedCategoryType.PUBLIC_FEED, null))
    }


    fun loadFeed() {
        this.flickrRepository.loadCats(catsFeedCallback)
        this.flickrRepository.loadDogs(dogsFeedCallback)
        this.flickrRepository.loadPublicFeed(publicFeedCallback)
    }

    private val catsFeedCallback = object : Callback<Feed> {
        override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
            categoryList[CATS_POSITION].feedItems = response.body().items.sortedByDescending { it.dateTaken }
            feedCategoriesLiveData.value = categoryList
        }
        override fun onFailure(call: Call<Feed>, t: Throwable) {
            Log.w(TAG, "Failed to get feed!!!")
        }
    }
    private val dogsFeedCallback =  object : Callback<Feed> {
        override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
            categoryList[DOGS_POSITION].feedItems = response.body().items.sortedByDescending { it.dateTaken }
            feedCategoriesLiveData.value = categoryList
        }

        override fun onFailure(call: Call<Feed>, t: Throwable) {
            Log.w(TAG, "Failed to get feed!!!")
        }
    }
    private val publicFeedCallback =  object : Callback<Feed> {
        override fun onResponse(call: Call<Feed>, response: Response<Feed>) {
            categoryList[PUBLIC_FEED_POSITION].feedItems = response.body().items.sortedByDescending { it.dateTaken }
            feedCategoriesLiveData.value = categoryList
        }

        override fun onFailure(call: Call<Feed>, t: Throwable) {
            Log.w(TAG, "Failed to get feed!!!")
        }
    }
}
