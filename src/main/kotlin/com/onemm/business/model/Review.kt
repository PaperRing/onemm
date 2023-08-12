package com.onemm.business.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class Review(
    val id: Long,
    val storeId: Long,
    val userId: Long,
    var content: String,
    var rating: Double?,
    var createAt: Date?,
    var updateAt: Date?,
    var s3: Boolean,
)