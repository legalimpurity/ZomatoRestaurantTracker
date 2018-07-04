package com.legalimpurity.zomatorestauranttracker.data.model.api.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class User() : Parcelable{

	@field:SerializedName("name")
	var name: String? = null

    @field:SerializedName("profile_image")
    var profileImage: String? = null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        profileImage = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(profileImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}