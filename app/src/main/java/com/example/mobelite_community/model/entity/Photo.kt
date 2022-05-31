package com.example.mobelite_community.model.entity

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Photo(@SerializedName("id")val id :String,
                 @SerializedName("created_at")val created_at :String,
                 @SerializedName("updated_at")val updated_at :String,
                 @SerializedName("width")val width: Int,
                 @SerializedName("height")val height : Int,
                 @SerializedName("description")val description: String,
                 @SerializedName("color")  val color: String,
                 @SerializedName("alt_description")  val alt_description: String,
                 @SerializedName("urls")  val url: PhotoUrl,
                 @SerializedName("user")  val user: User,
                 @SerializedName("likes")  val likes: String,
                 @SerializedName("sponsorship") val sponsorship: Sponsorship,
                 @SerializedName("exif")  val exif: Exif){

  var photos = ArrayList<Photo>()
}