package com.onemm.business.model

data class LikeStore(
    val id: Long,
    val userId: Long,
    val storeId: Long,
    val bool: Boolean
)
