package com.fedmog1lnkv.mangareader.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookmarkDto(
    val name: String?,
    val mangas: List<MangaDto>?,
    @SerialName("display_color") val displayColor: String?
)