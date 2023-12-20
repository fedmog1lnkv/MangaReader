package com.fedmog1lnkv.mangareader.domain.repository

import com.fedmog1lnkv.mangareader.domain.model.Bookmark
import com.fedmog1lnkv.mangareader.domain.model.Manga

interface MangaRepository {
    suspend fun getMangas(): List<Manga>
    suspend fun getBookmarks(): List<Bookmark>
    suspend fun getManga(id: String): Manga
}