package com.fedmog1lnkv.mangareader.domain.model

data class User(
    val image: String,
    val name: String,
    val statistics: List<UserStatisticItem>
)