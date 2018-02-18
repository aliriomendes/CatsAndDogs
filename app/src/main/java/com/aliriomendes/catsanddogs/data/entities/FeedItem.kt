package com.aliriomendes.catsanddogs.data.entities
import android.os.Parcel
import android.os.Parcelable
import com.aliriomendes.catsanddogs.util.readDate
import com.aliriomendes.catsanddogs.util.writeDate
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by aliriomendes on 13/02/2018.
 */
data class FeedItem(
        @SerializedName("title")        val title: String?,
        @SerializedName("link")         val link: String?,
        @SerializedName("media")        val media: Media?,
        @SerializedName("dateTaken")    val dateTaken: Date?,
        @SerializedName("description")  val description: String,
        @SerializedName("published")    val published: Date?,
        @SerializedName("author")       val author: String?,
        @SerializedName("authorId")     val authorId: String?,
        @SerializedName("tags")         val tags: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Media::class.java.classLoader),
            parcel.readDate(),
            parcel.readString(),
            parcel.readDate(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(link)
        parcel.writeParcelable(media, flags)
        parcel.writeDate(dateTaken)
        parcel.writeString(description)
        parcel.writeDate(published)
        parcel.writeString(author)
        parcel.writeString(authorId)
        parcel.writeString(tags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FeedItem> {
        override fun createFromParcel(parcel: Parcel): FeedItem {
            return FeedItem(parcel)
        }

        override fun newArray(size: Int): Array<FeedItem?> {
            return arrayOfNulls(size)
        }
    }
}