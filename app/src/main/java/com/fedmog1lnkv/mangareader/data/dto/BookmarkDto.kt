package com.fedmog1lnkv.mangareader.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookmarkDTO(
    val reading: List<MangaDTO>,
    @SerialName("in_plans") val inPlans: List<MangaDTO>,
    val done: List<MangaDTO>,
    val deferred: List<MangaDTO>,
    val abandoned: List<MangaDTO>
)