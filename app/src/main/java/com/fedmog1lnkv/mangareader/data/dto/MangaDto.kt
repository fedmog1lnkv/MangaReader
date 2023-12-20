package com.fedmog1lnkv.mangareader.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class MangaDto(
    val id: String,
    val title: String,
    val image: String,
    val description: String,
    val countChapters: Int,
    val stars: Double
)