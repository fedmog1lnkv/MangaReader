package com.fedmog1lnkv.mangareader.domain.model

data class Bookmark(
    val name: String,
    val mangas: List<Manga>,
    val displayColor: String
)