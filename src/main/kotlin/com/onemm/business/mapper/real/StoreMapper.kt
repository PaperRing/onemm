package com.onemm.business.mapper.real

import com.onemm.business.model.Store
import com.onemm.common.annotation.Real

@Real
interface StoreMapper {
    fun getStores(): List<Map<String, Any>>
    fun getStoresWithCategory(): List<Map<String, Any>>
    fun getStoreByName(name: String): List<Map<String, Any>>
    fun getStoreById(id: Long): Store
    fun getFacility(id: Long): List<Map<String, Any>>
    fun getCategory(id: Long): List<Map<String, Any>>
    fun getWorkDay(id: Long): List<Map<String, Any>>
    fun getMenu(id: Long): List<Map<String, Any>>
    fun filterStoresByCategory(categoryId: Long): List<Map<String, Any>>
    fun getStoresByCategoryId(categoryId: Long): List<Map<String, Any>>
    fun updateRating(id: Long)
    fun getStoresOrderByReviewCount(): List<Map<String, Any>>
}