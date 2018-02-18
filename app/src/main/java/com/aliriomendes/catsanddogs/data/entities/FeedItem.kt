package com.aliriomendes.catsanddogs.data.entities
import java.util.*

/**
 * Created by aliriomendes on 13/02/2018.
 */
class FeedItem(
        val title: String,
        val link: String,
        val media: Media,
        val date_taken: Date,
        val description: String,
        val published: Date,
        val author: String,
        val author_id: String,
        val tags: String) {
    override fun toString(): String {
        return "FeedItem(title='$title', " +
                "link='$link', " +
                "media=$media, " +
                "date_taken=$date_taken, " +
                "description='$description', " +
                "published=$published, " +
                "author='$author', " +
                "author_id='$author_id', " +
                "tags='$tags')"
    }
}