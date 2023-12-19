package com.fedmog1lnkv.mangareader.domain.model

data class Bookmark(
    val reading: List<Manga>,
    val inPlans: List<Manga>,
    val done: List<Manga>,
    val deferred: List<Manga>,
    val abandoned: List<Manga>
)