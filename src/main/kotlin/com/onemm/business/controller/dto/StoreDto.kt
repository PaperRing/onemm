package com.onemm.business.controller.dto

data class StoreDto(
    val id: Long? = -1,
    val name: String,
    val address: String,
    val tel: String,
    val homepage: String,
    val facility: List<String>,
    val category: List<String>,
    val menu: List<Pair<String, Any>>,
    val workDay: List<Pair<String, Any>>
)