package com.onemm.business.mapper.real

import com.onemm.business.model.User
import com.onemm.common.annotation.Real

@Real
interface Test3Mapper {

    fun test(): String
    fun all(): List<Map<String, Any>>
    fun findById(id: String): User?
    fun saveUser(user: User)
    fun deleteById(id: String)
    fun updateUser(id: String?, user: User)
    fun update(user: User)
}
