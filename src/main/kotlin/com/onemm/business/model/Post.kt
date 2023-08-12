package com.onemm.business.model

data class Post(
    val postId: Long,
    val title: String,
    val content: String,
    val author: String
)