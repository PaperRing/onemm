package com.onemm.business.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class ThemeListDto(
    val id: Long?,
    val userId: Long,
    val title: String,
    val description: String,
    val share: Boolean
)
