package com.fedmog1lnkv.mangareader.data.repository

import android.content.Context
import com.fedmog1lnkv.mangareader.data.dto.BookmarkDataDto
import com.fedmog1lnkv.mangareader.data.dto.HomeDataDto
import com.fedmog1lnkv.mangareader.data.mapper.BookmarkMapper
import com.fedmog1lnkv.mangareader.data.mapper.MangaMapper
import com.fedmog1lnkv.mangareader.domain.model.Bookmark
import com.fedmog1lnkv.mangareader.domain.model.Manga
import com.fedmog1lnkv.mangareader.domain.repository.MangaRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MangaRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson,
) : MangaRepository {
    override suspend fun getMangas(): List<Manga> = withContext(Dispatchers.IO) {
        context.resources.openRawResource(com.fedmog1lnkv.mangareader.R.raw.home_data).use { inputStream ->
            val buffer = ByteArray(inputStream.available())
            inputStream.read(buffer)
            val jsonString = String(buffer, Charsets.UTF_8)

            val homeData = gson.fromJson(jsonString, HomeDataDto::class.java)
            return@withContext homeData.mangas.map {
                MangaMapper.fromDto(it)
            }
        }
    }

    override suspend fun getBookmarks(): List<Bookmark> = withContext(Dispatchers.IO) {
        context.resources.openRawResource(com.fedmog1lnkv.mangareader.R.raw.bookmarks_data).use { inputStream ->
            val buffer = ByteArray(inputStream.available())
            inputStream.read(buffer)
            val jsonString = String(buffer, Charsets.UTF_8)

            val bookmarksData = gson.fromJson(jsonString, BookmarkDataDto::class.java)
            return@withContext bookmarksData.bookmarks.map {
                BookmarkMapper.fromDto(it)
            }
        }
    }

    override suspend fun getManga(id: String): Manga = withContext(Dispatchers.IO) {
        context.resources.openRawResource(com.fedmog1lnkv.mangareader.R.raw.home_data).use { inputStream ->
            val buffer = ByteArray(inputStream.available())
            inputStream.read(buffer)
            val jsonString = String(buffer, Charsets.UTF_8)

            val homeData = gson.fromJson(jsonString, HomeDataDto::class.java)
            val manga = homeData.mangas.firstOrNull { it.id == id } ?: throw Exception("Manga with id $id not found")
            return@withContext MangaMapper.fromDto(manga)
        }
    }
}