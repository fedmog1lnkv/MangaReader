package com.fedmog1lnkv.mangareader.data.mapper

import com.fedmog1lnkv.mangareader.data.dto.UserStatisticsDTO
import com.fedmog1lnkv.mangareader.domain.model.UserStatistics

object UserStatisticsMapper {
    fun toDto(statistics: UserStatistics) = UserStatisticsDTO(
        reading = statistics.reading,
        inPlans = statistics.inPlans,
        done = statistics.done,
        deferred = statistics.deferred,
        abandoned = statistics.abandoned
    )

    fun fromDto(dto: UserStatisticsDTO) = UserStatistics(
        reading = dto.reading,
        inPlans = dto.inPlans,
        done = dto.done,
        deferred = dto.deferred,
        abandoned = dto.abandoned
    )
}