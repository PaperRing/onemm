package com.onemm.business.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.onemm.business.service.DBMappingService
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class DbMappingController(
    private val objectMapper: ObjectMapper,
    private val dbMappingService: DBMappingService,

    @Value("classpath:jsonFiles/cafe_신림동.json")
    private val resource: Resource
) {

    @GetMapping("/file")
    fun jsonToDB() {
        val result: Map<String, Any> = objectMapper.readValue(resource.file)
        val storeList = dbMappingService.saveStore(result)

        dbMappingService.saveStoreFacility(storeList)
        dbMappingService.saveStoreCategory(storeList)
        dbMappingService.saveMenu(storeList)
        dbMappingService.saveWorkDay(storeList)
    }

}