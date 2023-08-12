package com.onemm.business.mapper.real

import com.onemm.business.model.LikeThemeList
import com.onemm.business.model.ThemeItem
import com.onemm.business.model.ThemeListDto
import com.onemm.common.annotation.Real

@Real
interface ThemeListMapper {
    fun addThemeList(themeListDto: ThemeListDto)
    fun addThemeItem(themeItem: ThemeItem)
    fun getThemeListAll(userId: Long): List<Map<String, Any>>
    fun getThemeListItems(id: Long): List<Map<String, Any>>
    fun getThemeListAllByUser(userId: Long): List<Map<String, Any>>
    fun deleteThemeList(id: Long)
    fun deleteThemeItem(themeId: Long, storeId: Long)
    fun addThemeListLike(likeThemeList: LikeThemeList)
    fun getLikeThemeList(userId: Long): List<Map<String, Any>>
    fun deleteThemeListLike(userId: Long, themeId: Long)
    fun getThemeListOrderByLike(): List<Map<String, Any>>
    fun getLikeOneTheme(userId: Long, themeId: Long): LikeThemeList
    fun getOneThemeList(themeId: Long): ThemeListDto
    fun updateThemeList(id: Long, themeListDto: ThemeListDto)
}