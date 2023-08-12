package com.onemm.business.controller

import com.onemm.business.mapper.real.LikeStoreMapper
import com.onemm.business.model.LikeStore
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/like")
class LikeController(
    private val likeStoreMapper: LikeStoreMapper
) {

    @PostMapping("/add")
    fun addLike(@RequestBody likeStore: LikeStore) {
        likeStoreMapper.addLike(likeStore)
    }

    @GetMapping("/get/all/{userId}")
    fun getAllLikeByUser(@PathVariable userId: Long): List<Map<String, Any>> {
        return likeStoreMapper.getAllLikeByUser(userId)
    }

    @GetMapping("/get/store/{userId}/{storeId}")
    fun getLikeByStore(
        @PathVariable("userId") userId: Long, @PathVariable("storeId") storeId: Long
    ): LikeStore {
        return likeStoreMapper.getLikeByStore(userId, storeId)
    }

    @DeleteMapping("/delete")
    fun deleteLike(@RequestParam("userId") userId: Long, @RequestParam("storeId") storeId: Long) {
        likeStoreMapper.deleteLike(userId, storeId)
    }


}