package com.fedmog1lnkv.mangareader.domain.interactor

import com.fedmog1lnkv.mangareader.domain.model.Bookmark
import com.fedmog1lnkv.mangareader.domain.model.Manga
import com.fedmog1lnkv.mangareader.domain.repository.MangaRepository
import javax.inject.Inject

class MangaInteractor @Inject constructor(
    private val mangaRepository: MangaRepository
) {
    fun getMangas(): List<Manga> {
        return mangaRepository.getMangas()
    }

    fun getBookmark(): Bookmark {
        return mangaRepository.getBookmark()
    }
}