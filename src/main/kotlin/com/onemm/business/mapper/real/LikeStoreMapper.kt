package com.onemm.business.mapper.real

import com.onemm.business.model.LikeStore
import com.onemm.common.annotation.Real

@Real
interface LikeStoreMapper {
    fun addLike(likeStore: LikeStore)
    fun getAllLikeByUser(userId: Long): List<Map<String, Any>>
    fun getLikeByStore(userId: Long, storeId: Long): LikeStore
    fun deleteLike(userId: Long, storeId: Long)
}