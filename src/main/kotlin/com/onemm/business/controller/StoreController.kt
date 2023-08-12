package com.onemm.business.controller

import com.onemm.business.mapper.real.StoreMapper
import com.onemm.business.model.Store
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/stores")
class StoreController(
    private val stroeMapper: StoreMapper
) {

    @GetMapping("")
    fun getStores(): List<Map<String, Any>> {
        return stroeMapper.getStores()
    }

    @GetMapping("/filter/{categoryId}")
    fun getStoresByCategoryId(@PathVariable categoryId: Long): List<Map<String, Any>> {
        return stroeMapper.getStoresByCategoryId(categoryId)
    }

    @GetMapping("/all/category")
    fun getStoresWithCategory(): List<Map<String, Any>> {
        return stroeMapper.getStoresWithCategory()
    }

    @GetMapping("/name/{name}")
    fun getStoreByName(@PathVariable("name") name: String): List<Map<String, Any>> {
        return stroeMapper.getStoreByName(name)
    }

    @GetMapping("/id/{id}")
    fun getStoreById(@PathVariable("id") id: Long): Store {
        return stroeMapper.getStoreById(id)
    }

    @GetMapping("/fac/{id}")
    fun getFacility(@PathVariable("id") id: Long): List<Map<String, Any>> {
        return stroeMapper.getFacility(id)
    }

    @GetMapping("/category/{id}")
    fun getCategory(@PathVariable("id") id: Long): List<Map<String, Any>> {
        return stroeMapper.getCategory(id)
    }

    @GetMapping("/workday/{id}")
    fun getWorkDay(@PathVariable("id") id: Long): List<Map<String, Any>> {
        return stroeMapper.getWorkDay(id)
    }

    @GetMapping("/menu/{id}")
    fun getMenu(@PathVariable("id") id: Long): List<Map<String, Any>> {
        return stroeMapper.getMenu(id)
    }

    @PutMapping("/update/rating/{id}")
    fun updateRating(@PathVariable id: Long) {
        return stroeMapper.updateRating(id)
    }

    @GetMapping("/review-count-order")
    fun getStoresOrderByReviewCount(): List<Map<String, Any>> {
        return stroeMapper.getStoresOrderByReviewCount()
    }


}