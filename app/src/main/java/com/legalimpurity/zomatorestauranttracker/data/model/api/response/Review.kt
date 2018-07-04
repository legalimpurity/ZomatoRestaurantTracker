package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull

@Entity(tableName = "Reviews")
class Review() : Parcelable {

    @ColumnInfo(name = "restaurantId")
    var restaurantId: Long = 0

    @ColumnInfo(name = "reviewerName")
    var reviewerName: String = ""

    @ColumnInfo(name = "reviewerImageUrl")
    var reviewerImageUrl: String = ""

    @Expose
	@ColumnInfo(name = "rating_text")
	@field:SerializedName("rating_text")
	var ratingText: String? = null

	@Expose
	@ColumnInfo(name = "id")
    @PrimaryKey
	@field:SerializedName("id")
	var id: Long = 0

    @Ignore
	@field:SerializedName("user")
	var user: User? = null

	constructor(parcel: Parcel) : this() {
		restaurantId = parcel.readLong()
		ratingText = parcel.readString()
		id = parcel.readLong()
		user = parcel.readParcelable(User::class.java.classLoader)
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeLong(restaurantId)
		parcel.writeString(ratingText)
		parcel.writeLong(id)
		parcel.writeParcelable(user, flags)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Review> {
		override fun createFromParcel(parcel: Parcel): Review {
			return Review(parcel)
		}

		override fun newArray(size: Int): Array<Review?> {
			return arrayOfNulls(size)
		}
	}
}