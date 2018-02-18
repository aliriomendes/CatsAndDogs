package com.aliriomendes.catsanddogs.data.entities
import com.google.gson.annotations.SerializedName
import java.util.*
/**
 * Created by aliriomendes on 13/02/2018.
 */
data class Feed(
        @SerializedName("title")        val title: String,
        @SerializedName("link")         val link: String,
        @SerializedName("description")  val description:String,
        @SerializedName("modified")     val modified: Date,
        @SerializedName("generator")    val generator: String,
        @SerializedName("items")        val items: List<FeedItem>)