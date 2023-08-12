package com.onemm.business.model

data class Follow(
    val id: Long,
    val loginId: Long,
    val followingId: Long,
)
