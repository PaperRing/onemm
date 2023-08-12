package com.onemm.business.model

data class WorkDay(
    val id: Long? = -1,
    val storeId: Long?,
    val day: String,
    val time: String,
)
