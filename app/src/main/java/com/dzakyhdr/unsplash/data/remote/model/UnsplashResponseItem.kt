package com.dzakyhdr.unsplash.data.remote.model


import com.google.gson.annotations.SerializedName

data class UnsplashResponseItem(
    @SerializedName("alt_description")
    val altDescription: String? = "",
    @SerializedName("blur_hash")
    val blurHash: String? = "",
    @SerializedName("color")
    val color: String? = "",
    @SerializedName("created_at")
    val createdAt: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("height")
    val height: Int? = 0,
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("liked_by_user")
    val likedByUser: Boolean? = false,
    @SerializedName("likes")
    val likes: Int? = 0,
    @SerializedName("updated_at")
    val updatedAt: String? = "",
    @SerializedName("urls")
    val urls: Urls = Urls("", "", "", "", "", ""),
    @SerializedName("user")
    val user: User = User(false, "", "", false, "", "", "", "", "", "", 0, 0, 0, "", "", ""),
    @SerializedName("width")
    val width: Int = 0
)