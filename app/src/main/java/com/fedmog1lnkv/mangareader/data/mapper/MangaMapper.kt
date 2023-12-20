package com.fedmog1lnkv.mangareader.data.mapper

import com.fedmog1lnkv.mangareader.data.dto.MangaDto
import com.fedmog1lnkv.mangareader.domain.model.Manga

object MangaMapper {
    fun toDto(manga: Manga) = MangaDto(
        id = manga.id,
        title = manga.title,
        image = manga.image,
        description = manga.description,
        countChapters = manga.countChapters,
        stars = manga.stars
    )

    fun fromDto(dto: MangaDto) = Manga(
        id = dto.id,
        title = dto.title,
        image = dto.image,
        description = dto.description,
        countChapters = dto.countChapters,
        stars = dto.stars
    )
}