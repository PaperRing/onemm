package com.onemm.business.mapper.real

import com.onemm.business.model.Search
import com.onemm.common.annotation.Real

@Real
interface SearchMapper {
    fun searchStoreName(name: String): List<Map<String, Any>>
    fun saveSearchRecord(search: Search)
    fun getSearchRecord(userId: Long): List<Map<String, Any>>
    fun deleteRecord(id: Long)
}