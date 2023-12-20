package com.fedmog1lnkv.mangareader.data.mapper

import com.fedmog1lnkv.mangareader.data.dto.UserStatisticItemDto
import com.fedmog1lnkv.mangareader.domain.model.UserStatisticItem

object UserStatisticItemMapper {
    fun toDto(statistic: UserStatisticItem) = UserStatisticItemDto(
        name = statistic.name,
        displayColor = statistic.displayColor,
        count = statistic.count
    )

    fun fromDto(dto: UserStatisticItemDto) = UserStatisticItem(
        name = dto.name,
        displayColor = dto.displayColor,
        count = dto.count
    )
}