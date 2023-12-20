package com.fedmog1lnkv.mangareader.domain.interactor

import com.fedmog1lnkv.mangareader.domain.model.Bookmark
import com.fedmog1lnkv.mangareader.domain.model.Manga
import com.fedmog1lnkv.mangareader.domain.model.UserStatisticItem
import com.fedmog1lnkv.mangareader.domain.repository.MangaRepository
import javax.inject.Inject

class MangaInteractor @Inject constructor(
    private val mangaRepository: MangaRepository
) {
    suspend fun getMangas(): List<Manga> {
        return mangaRepository.getMangas()
    }

    suspend fun getBookmarks(): List<Bookmark> {
        return mangaRepository.getBookmarks()
    }

    suspend fun getManga(id: String): Manga {
        return mangaRepository.getManga(id)
    }

    suspend fun getStatistics(): List<UserStatisticItem> {
        val mangas = mangaRepository.getBookmarks().map {
            UserStatisticItem(it.name, it.mangas.size, it.displayColor)
        }
        return mangas
    }
}