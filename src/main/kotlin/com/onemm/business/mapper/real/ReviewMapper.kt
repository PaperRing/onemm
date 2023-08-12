package com.onemm.business.mapper.real

import com.onemm.business.model.ReviewDto
import com.onemm.common.annotation.Real

@Real
interface ReviewMapper {
    fun getReviewByStoreId(storeId: Long, userId: Long): List<Map<String, Any>>
    fun saveReview(reviewDto: ReviewDto)
    fun updateReview(id: Long, reviewDto: ReviewDto)
    fun getReviewByUser(id: Long): List<Map<String, Any>>
    fun getReviewById(id: Long): ReviewDto
    fun getOrderBySelectedReview(id: Long, storeId: Long, userId: Long): List<Map<String, Any>>
    fun deleteReview(id: Long)
    fun getLatestReviewImage(storeId: Long): ReviewDto
}