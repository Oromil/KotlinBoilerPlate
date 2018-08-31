package com.oromil.kotlinboilerplate.data.network.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class StoryEntity(
        @SerializedName("section")
        @Expose
        var section: String,
        @SerializedName("subsection")
        @Expose
        var subsection: String,
        @SerializedName("title")
        @Expose
        var title: String,
        @SerializedName("abstract")
        @Expose
        var abstract: String,
        @SerializedName("url")
        @Expose
        var url: String,
        @SerializedName("byline")
        @Expose
        var byline: String,
        @SerializedName("item_type")
        @Expose
        var itemType: String,
        @SerializedName("updated_date")
        @Expose
        var updatedDate: String,
        @SerializedName("created_date")
        @Expose
        var createdDate: String,
        @SerializedName("published_date")
        @Expose
        var publishedDate: String,
        @SerializedName("material_type_facet")
        @Expose
        var materialTypeFacet: String,
        @SerializedName("kicker")
        @Expose
        var kicker: String,
        @SerializedName("des_facet")
        @Expose
        var desFacet: List<String>,
        @SerializedName("org_facet")
        @Expose
        var orgFacet: List<String>,
        @SerializedName("per_facet")
        @Expose
        var perFacet: List<String>,
        @SerializedName("geo_facet")
        @Expose
        var geoFacet: List<String>,
        @SerializedName("multimedia")
        @Expose
        var multimedia: ArrayList<MultimediaEntity>,
        @SerializedName("short_url")
        @Expose
        var shortUrl: String
        )

