package com.fedmog1lnkv.mangareader.data.mapper

import com.fedmog1lnkv.mangareader.data.dto.BookmarkDTO
import com.fedmog1lnkv.mangareader.domain.model.Bookmark

object BookmarkMapper {
    fun toDto(bookmark: Bookmark) = BookmarkDTO(
        reading = bookmark.reading.map { MangaMapper.toDto(it) },
        inPlans = bookmark.inPlans.map { MangaMapper.toDto(it) },
        done = bookmark.done.map { MangaMapper.toDto(it) },
        deferred = bookmark.deferred.map { MangaMapper.toDto(it) },
        abandoned = bookmark.abandoned.map { MangaMapper.toDto(it) }
    )

    fun fromDto(dto: BookmarkDTO) = Bookmark(
        reading = dto.reading.map { MangaMapper.fromDto(it) },
        inPlans = dto.inPlans.map { MangaMapper.fromDto(it) },
        done = dto.done.map { MangaMapper.fromDto(it) },
        deferred = dto.deferred.map { MangaMapper.fromDto(it) },
        abandoned = dto.abandoned.map { MangaMapper.fromDto(it) }
    )
}