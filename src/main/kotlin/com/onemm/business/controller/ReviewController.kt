package com.onemm.business.controller

import com.onemm.business.mapper.real.ReviewMapper
import com.onemm.business.model.ReviewDto
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/review")
class ReviewController(private val reviewMapper: ReviewMapper) {

    @PostMapping("/save")
    fun saveReview(@RequestBody reviewDto: ReviewDto) {
        print(reviewDto)
        reviewMapper.saveReview(reviewDto)
    }

    @GetMapping("/store/{id}/{userId}")
    fun getReviewByStoreId(
        @PathVariable(value = "id") id: Long, @PathVariable(value = "userId") userId: Long
    ): List<Map<String, Any>> {
        return reviewMapper.getReviewByStoreId(id, userId)
    }

    @PutMapping("/update/{id}")
    fun updateReview(@PathVariable id: Long, @RequestBody reviewDto: ReviewDto) {
        reviewMapper.updateReview(id, reviewDto)
    }

    @GetMapping("/user/{id}")
    fun getReviewByUser(@PathVariable id: Long): List<Map<String, Any>> {
        return reviewMapper.getReviewByUser(id)
    }

    @GetMapping("/{id}")
    fun getReviewById(@PathVariable id: Long): ReviewDto {
        return reviewMapper.getReviewById(id)
    }

    @GetMapping("/order/{id}/{storeId}/{userId}")
    fun getOrderBySelectedReview(
        @PathVariable(value = "id") id: Long,
        @PathVariable(value = "storeId") storeId: Long,
        @PathVariable(value = "userId") userId: Long,
    ): List<Map<String, Any>> {
        return reviewMapper.getOrderBySelectedReview(id, storeId, userId)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteReview(@PathVariable id: Long) {
        reviewMapper.deleteReview(id)
    }

    @GetMapping("/get/latest/{storeId}")
    fun getLatestReviewImage(@PathVariable storeId: Long): ReviewDto {
        return reviewMapper.getLatestReviewImage(storeId)
    }
}