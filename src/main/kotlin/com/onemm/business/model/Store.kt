package com.onemm.business.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Store(
    val id: Long = -1,
    val name: String = "",
    val address: String = "",
    val tel: String = "",
    val homepage: String = "",
    val dong: String = "",
    val averageRating: Double = 0.0,
    val count: Long = 0,

    )
