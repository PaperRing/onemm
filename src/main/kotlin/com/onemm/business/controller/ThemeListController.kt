package com.onemm.business.controller

import com.onemm.business.mapper.real.ThemeListMapper
import com.onemm.business.model.LikeThemeList
import com.onemm.business.model.ThemeItem
import com.onemm.business.model.ThemeListDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/theme")
class ThemeListController(
    private val themeListMapper: ThemeListMapper
) {

    @PostMapping("/add/list")
    fun addThemeList(@RequestBody themeListDto: ThemeListDto) {
        themeListMapper.addThemeList(themeListDto)
    }

    @PostMapping("/add/item")
    fun addThemeItem(@RequestBody themeItem: ThemeItem) {
        themeListMapper.addThemeItem(themeItem)
    }

    @GetMapping("/get/all/{userId}")
    fun getThemeListAll(@PathVariable userId: Long): List<Map<String, Any>> {
        return themeListMapper.getThemeListAll(userId)
    }

    @GetMapping("/get/by/{userId}")
    fun getThemeListAllByUser(@PathVariable userId: Long): List<Map<String, Any>> {
        return themeListMapper.getThemeListAllByUser(userId)
    }

    @GetMapping("/get/one/{id}")
    fun getThemeListItems(@PathVariable id: Long): List<Map<String, Any>> {
        return themeListMapper.getThemeListItems(id)
    }

    @DeleteMapping("/delete/list/{id}")
    fun deleteThemeList(@PathVariable id: Long) {
        themeListMapper.deleteThemeList(id)
    }

    @DeleteMapping("/delete/item")
    fun deleteThemeItem(
        @RequestParam("themeId") themeId: Long,
        @RequestParam("storeId") storeId: Long
    ) {
        themeListMapper.deleteThemeItem(themeId, storeId)
    }

    @PostMapping("/like/add")
    fun addThemeListLike(@RequestBody likeThemeList: LikeThemeList) {
        themeListMapper.addThemeListLike(likeThemeList)
    }

    @GetMapping("/like/get/{userId}")
    fun getLikeThemeList(@PathVariable userId: Long): List<Map<String, Any>> {
        return themeListMapper.getLikeThemeList(userId)
    }

    @DeleteMapping("/like/delete")
    fun deleteThemeListLike(@RequestParam userId: Long, @RequestParam themeId: Long) {
        themeListMapper.deleteThemeListLike(userId, themeId)
    }

    @GetMapping("/get/list/order/like")
    fun getThemeListOrderByLike(): List<Map<String, Any>> {
        return themeListMapper.getThemeListOrderByLike()
    }

    @GetMapping("/like/get/one/{userId}/{themeId}")
    fun getLikeOneTheme(@PathVariable userId: Long, @PathVariable themeId: Long): LikeThemeList {
        return themeListMapper.getLikeOneTheme(userId, themeId)
    }

    @GetMapping("/get/one/list/{themeId}")
    fun getOneThemeList(@PathVariable themeId: Long): ThemeListDto {
        return themeListMapper.getOneThemeList(themeId)
    }

    @PutMapping("/update/{id}")
    fun updateThemeList(@PathVariable id: Long, @RequestBody themeListDto: ThemeListDto) {
        themeListMapper.updateThemeList(id, themeListDto)
    }

}