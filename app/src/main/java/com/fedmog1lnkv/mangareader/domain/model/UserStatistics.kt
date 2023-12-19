package com.fedmog1lnkv.mangareader.domain.model

data class UserStatistics(
    val reading: Int,
    val inPlans: Int,
    val done: Int,
    val deferred: Int,
    val abandoned: Int
)
