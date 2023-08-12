package com.onemm.business.model

data class LikeThemeList(
    val id: Long,
    val userId: Long,
    val themeId: Long,
    val bool: Boolean

)
