package com.oromil.kotlinboilerplate.data.network.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class MultimediaEntity(
        @SerializedName("url")
        @Expose
        var url: String,
        @SerializedName("format")
        @Expose
        var format: String,
        @SerializedName("height")
        @Expose
        var height: Int,
        @SerializedName("width")
        @Expose
        var width: Int,
        @SerializedName("type")
        @Expose
        var type: String,
        @SerializedName("subtype")
        @Expose
        var subtype: String,
        @SerializedName("caption")
        @Expose
        var caption: String,
        @SerializedName("copyright")
        @Expose
        var copyright: String
)
