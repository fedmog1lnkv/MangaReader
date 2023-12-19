package com.fedmog1lnkv.mangareader.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserStatisticsDTO(
    val reading: Int,
    @SerialName("in_plans") val inPlans: Int,
    val done: Int,
    val deferred: Int,
    val abandoned: Int
)