package com.fedmog1lnkv.mangareader.data.repository

import android.content.Context
import com.fedmog1lnkv.mangareader.data.dto.HomeDataDto
import com.fedmog1lnkv.mangareader.data.mapper.MangaMapper
import com.fedmog1lnkv.mangareader.domain.model.Bookmark
import com.fedmog1lnkv.mangareader.domain.model.Manga
import com.fedmog1lnkv.mangareader.domain.repository.MangaRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MangaRepositoryImpl @Inject constructor(@ApplicationContext private val context: Context) :
    MangaRepository {
    override fun getMangas(): List<Manga> {
        context.resources.openRawResource(com.fedmog1lnkv.mangareader.R.raw.home_data)
            .use { inputStream ->
                val buffer = ByteArray(inputStream.available())
                inputStream.read(buffer)
                val jsonString = String(buffer, Charsets.UTF_8)

                val gson = Gson()

                val homeData = gson.fromJson(jsonString, HomeDataDto::class.java)
                return homeData.mangas.map { it ->
                    MangaMapper.fromDto(it)
                }
            }
    }


    override fun getBookmark(): Bookmark {
        TODO("Not yet implemented")
    }
}