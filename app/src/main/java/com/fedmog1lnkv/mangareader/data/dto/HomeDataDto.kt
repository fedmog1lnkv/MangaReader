package com.fedmog1lnkv.mangareader.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class HomeDataDto(
    val mangas: List<MangaDTO>
)
