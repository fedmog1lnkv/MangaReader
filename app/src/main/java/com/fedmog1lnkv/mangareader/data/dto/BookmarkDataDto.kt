package com.fedmog1lnkv.mangareader.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class BookmarkDataDto(
    val bookmarks: List<BookmarkDto>,
)