package com.onemm.business.mapper.real

import com.onemm.business.model.Report
import com.onemm.common.annotation.Real

@Real
interface ReportMapper {
    fun addReport(report: Report)
}