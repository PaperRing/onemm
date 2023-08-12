package com.onemm.business.model

import java.util.*

data class ThemeList(
    val id: Long,
    val userId: Long,
    val title: String,
    val description: String,
    val createAt: Date,
    val updateAt: Date,
    val share: Boolean,
)
