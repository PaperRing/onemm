package com.onemm.business.mapper.real

import com.onemm.business.model.Post
import com.onemm.common.annotation.Real

@Real
interface PostMapper {
    fun savePost(post: Post)
    fun findAll(): List<Map<String, Any>>
    fun findByUserName(author: String): List<Map<String, Any>>
}