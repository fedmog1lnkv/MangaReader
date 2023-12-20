package com.fedmog1lnkv.mangareader.data.dto

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class UserStatisticItemDto (
    val name: String,
    @SerializedName("display_color") val displayColor: String,
    @SerializedName("count_mangas") val count: Int
)