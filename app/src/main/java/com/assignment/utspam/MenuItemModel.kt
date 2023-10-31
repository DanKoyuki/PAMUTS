package com.assignment.utspam

import android.os.Parcel
import android.os.Parcelable

data class MenuItemModel(val image: Int, val title:String, val desc:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(title)
        parcel.writeString(desc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MenuItemModel> {
        override fun createFromParcel(parcel: Parcel): MenuItemModel {
            return MenuItemModel(parcel)
        }

        override fun newArray(size: Int): Array<MenuItemModel?> {
            return arrayOfNulls(size)
        }
    }
}
