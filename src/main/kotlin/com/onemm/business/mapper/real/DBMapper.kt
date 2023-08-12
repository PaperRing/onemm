package com.onemm.business.mapper.real

import com.onemm.business.controller.dto.StoreDto
import com.onemm.business.model.*
import com.onemm.common.annotation.Real

@Real
interface DBMapper {

    fun getFacility(): List<Facility>
    fun getCategory(): List<Category>
    fun saveStore(storeList: List<StoreDto>)
    fun saveStoreFacility(storeFacilityList: List<StoreFacility>)
    fun saveStoreCategory(storeCategoryList: List<StoreCategory>)
    fun saveMenu(menuList: List<Menu>)
    fun saveWorkDay(workDayList: List<WorkDay>)

}