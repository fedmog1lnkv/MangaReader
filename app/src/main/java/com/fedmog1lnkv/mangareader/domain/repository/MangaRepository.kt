package com.fedmog1lnkv.mangareader.domain.repository

import com.fedmog1lnkv.mangareader.domain.model.Bookmark
import com.fedmog1lnkv.mangareader.domain.model.Manga

interface MangaRepository {
    fun getMangas(): List<Manga>
    fun getBookmark(): Bookmark
}