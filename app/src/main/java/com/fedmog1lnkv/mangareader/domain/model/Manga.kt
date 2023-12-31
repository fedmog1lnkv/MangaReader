package com.fedmog1lnkv.mangareader.domain.model

data class Manga(
    val id: String,
    val title: String,
    val image: String,
    val description: String,
    val countChapters: Int,
    val stars: Double
)