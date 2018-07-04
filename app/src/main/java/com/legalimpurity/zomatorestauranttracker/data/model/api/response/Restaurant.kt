package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull

@Entity(tableName = "Restaurants")
class Restaurant() : Parcelable {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    @field:SerializedName("id")
    var id: Long = 0


    @Expose
    @ColumnInfo(name = "featuredImage")
    @field:SerializedName("featured_image")
    var featured_image: String? = null

    @Expose
    @ColumnInfo(name = "thumb")
    @field:SerializedName("thumb")
    var thumb: String? = null

    @Expose
    @ColumnInfo(name = "menuUrl")
    @field:SerializedName("menu_url")
    var menuUrl: String? = null

    @Expose
    @ColumnInfo(name = "eventsUrl")
    @field:SerializedName("events_url")
    var eventsUrl: String? = null

    @Expose
    @ColumnInfo(name = "name")
    @field:SerializedName("name")
    var name: String? = null

    @Expose
    @ColumnInfo(name = "photosUrl")
    @field:SerializedName("photos_url")
    var photosUrl: String? = null

    constructor(parcel: Parcel) : this() {
        id = parcel.readLong()
        featured_image = parcel.readString()
        thumb = parcel.readString()
        menuUrl = parcel.readString()
        eventsUrl = parcel.readString()
        name = parcel.readString()
        photosUrl = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(featured_image)
        parcel.writeString(thumb)
        parcel.writeString(menuUrl)
        parcel.writeString(eventsUrl)
        parcel.writeString(name)
        parcel.writeString(photosUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Restaurant> {
        override fun createFromParcel(parcel: Parcel): Restaurant {
            return Restaurant(parcel)
        }

        override fun newArray(size: Int): Array<Restaurant?> {
            return arrayOfNulls(size)
        }
    }
}