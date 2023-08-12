package com.onemm.business.controller

import com.onemm.business.service.S3Service
import org.springframework.web.bind.annotation.*
import java.io.Serializable


@RestController
class S3Controller(private val s3Service: S3Service) {

    @PostMapping("/s3/preSignedUrl")
    private fun getPreSignedUrl(
        @RequestParam folder: String,
        @RequestParam fileName: String
    ): String {
        return s3Service.getPreSignedUrl(folder, fileName)
    }


    @GetMapping("/s3/download")
    private fun downloadPreSignedUrl(
        @RequestParam folder: String,
        @RequestParam fileName: String
    ): Map<String, Serializable>? {
        return s3Service.downloadPreSignedUrl(folder, fileName)
    }


}
