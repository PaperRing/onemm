package com.onemm.business.service

import com.onemm.business.controller.dto.StoreDto
import com.onemm.business.mapper.real.DBMapper
import com.onemm.business.model.*
import org.springframework.stereotype.Service

@Service
class DBMappingService(
    private val dbMapper: DBMapper,
) {


    fun getFacility(): List<Facility> {
        return dbMapper.getFacility()
    }


    fun getCategory(): List<Category> {
        return dbMapper.getCategory()
    }


    fun saveStore(storeList: Map<String, Any>): List<StoreDto> {
        val result: List<StoreDto> = storeList.map {
            val value = it.value as Map<String, Any>
            StoreDto(
                name = it.key,
                address = value["address"].toString(),
                tel = value["tel"].toString(),
                homepage = value["homepage"].toString(),
                facility = (value["facility"] as List<String>).map { it -> it.trim() },
                category = value["category"].toString().trim().split(","),
                menu = (value["menu"] as Map<String, Any>).toList(),
                workDay = (value["work_day"] as Map<String, Any>).toList()
            )
        }
        dbMapper.saveStore(result)
        return result
    }


    fun saveStoreFacility(storeList: List<StoreDto>) {
        val facilityList = getFacility()

        val result: List<StoreFacility> = storeList.fold(mutableListOf())
        { acc, store ->
            val storeFacilityList = store.facility
                .map { fac ->
                    val facilityId = facilityList.find { it.name == fac }?.id ?: -1
                    StoreFacility(store.id, facilityId)
                }
                .filter {
                    it.facilityId != -1L
                }
            return@fold acc.apply { addAll(storeFacilityList) }
        }
        dbMapper.saveStoreFacility(result)
    }


    fun saveStoreCategory(storeList: List<StoreDto>) {
        val categoryList = getCategory()

        val result: List<StoreCategory> = storeList.fold(mutableListOf())
        { acc, store ->
            val storeCateList = store.category
                .map { cate ->
                    val categoryId = categoryList.find { it.name == cate }?.id ?: -1
                    StoreCategory(store.id, categoryId)
                }
                .filter {
                    it.categoryId != -1L
                }
            return@fold acc.apply { addAll(storeCateList) }
        }
        dbMapper.saveStoreCategory(result)
    }


    fun saveMenu(storeList: List<StoreDto>) {
        val result: List<Menu> = storeList.fold(mutableListOf())
        { acc, store ->
            val menuMap = store.menu
                .map { menu: Pair<String, Any> ->
                    Menu(
                        storeId = store.id,
                        name = menu.first,
                        price = menu.second.toString()
                    )
                }
            return@fold acc.apply { addAll(menuMap) }
        }
        dbMapper.saveMenu(result)
    }


    fun saveWorkDay(storeList: List<StoreDto>) {
        val result: List<WorkDay> = storeList.fold(mutableListOf())
        { acc, store ->
            val workDayMap = store.workDay
                .map { workday: Pair<String, Any> ->
                    WorkDay(
                        storeId = store.id,
                        day = workday.first,
                        time = workday.second.toString()
                    )
                }
            return@fold acc.apply { addAll(workDayMap) }
        }
        dbMapper.saveWorkDay(result)
    }

}

