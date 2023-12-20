package com.fedmog1lnkv.mangareader.data.mapper

import com.fedmog1lnkv.mangareader.data.dto.UserDTO
import com.fedmog1lnkv.mangareader.domain.model.User

object UserMapper {
    fun toDto(user: User) = UserDTO(
        image = user.image,
        name = user.name,
        statistics = user.statistics.map {
            UserStatisticItemMapper.toDto(it)
        }
    )

    fun fromDto(dto: UserDTO) = User(
        image = dto.image,
        name = dto.name,
        statistics = dto.statistics.map {
            UserStatisticItemMapper.fromDto(it)
        }
    )
}