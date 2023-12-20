package com.fedmog1lnkv.mangareader.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    val image: String,
    val name: String,
    val statistics: List<UserStatisticItemDto>
)