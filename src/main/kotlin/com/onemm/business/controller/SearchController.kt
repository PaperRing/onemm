package com.onemm.business.controller

import com.onemm.business.mapper.real.SearchMapper
import com.onemm.business.model.Search
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/search")
class SearchController(
    val searchMapper: SearchMapper
) {

    @GetMapping("/name/{name}")
    fun searchStoreName(@PathVariable name: String): List<Map<String, Any>> {
        return searchMapper.searchStoreName(name)
    }

    @PostMapping("/save")
    fun saveSearchRecord(@RequestBody search: Search) {
        return searchMapper.saveSearchRecord(search)
    }

    @GetMapping("/get/{userId}")
    fun getSearchRecord(@PathVariable userId: Long): List<Map<String, Any>> {
        return searchMapper.getSearchRecord(userId)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteRecord(@PathVariable id: Long) {
        searchMapper.deleteRecord(id)
    }

}