package com.onemm.business.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
    val id: Long?,
    val uid: String?,
    val name: String?,
    val photoUrl: String?,
    val s3: Boolean?,
    val location: String?,
)
