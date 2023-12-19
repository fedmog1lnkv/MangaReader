package com.fedmog1lnkv.mangareader.data.mapper

import com.fedmog1lnkv.mangareader.data.dto.MangaDTO
import com.fedmog1lnkv.mangareader.domain.model.Manga

object MangaMapper {
    fun toDto(manga: Manga) = MangaDTO(
        title = manga.title,
        image = manga.image,
        description = manga.description,
        countChapters = manga.countChapters,
        stars = manga.stars
    )

    fun fromDto(dto: MangaDTO) = Manga(
        title = dto.title,
        image = dto.image,
        description = dto.description,
        countChapters = dto.countChapters,
        stars = dto.stars
    )
}