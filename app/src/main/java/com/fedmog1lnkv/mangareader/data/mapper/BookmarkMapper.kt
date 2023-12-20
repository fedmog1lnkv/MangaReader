package com.fedmog1lnkv.mangareader.data.mapper

import com.fedmog1lnkv.mangareader.data.dto.BookmarkDto
import com.fedmog1lnkv.mangareader.domain.model.Bookmark

object BookmarkMapper {
    fun toDto(bookmark: Bookmark) = BookmarkDto(
        name = bookmark.name,
        mangas = bookmark.mangas.map { MangaMapper.toDto(it) },
        displayColor = bookmark.displayColor
    )

    fun fromDto(dto: BookmarkDto) = Bookmark(
        name = dto.name.orEmpty(),
        mangas = dto.mangas?.map { MangaMapper.fromDto(it) }.orEmpty(),
        displayColor = dto.displayColor.orEmpty()
    )
}