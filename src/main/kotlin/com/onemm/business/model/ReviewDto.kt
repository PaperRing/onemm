package com.onemm.business.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ReviewDto(
    val id: Long,
    val storeId: Long,
    val userId: Long,
    var content: String,
    var rating: Double,
    var s3: Boolean,
)