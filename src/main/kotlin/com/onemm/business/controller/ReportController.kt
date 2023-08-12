package com.onemm.business.controller

import com.onemm.business.mapper.real.ReportMapper
import com.onemm.business.model.Report
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/review/report")
class ReportController(
    private val reportMapper: ReportMapper
) {
    @PostMapping("/add")
    fun addReport(@RequestBody report: Report) {
        reportMapper.addReport(report)
    }


}