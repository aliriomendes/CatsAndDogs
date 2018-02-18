package com.aliriomendes.catsanddogs.data.entities
import java.util.*
/**
 * Created by aliriomendes on 13/02/2018.
 */
class Feed(val title: String, val link: String, val description:String, val modified: Date, val generator: String, val items: List<FeedItem>){
    override fun toString(): String {
        return "Feed(title='$title', link='$link', description='$description', modified=$modified, generator='$generator', items=$items)"
    }
}