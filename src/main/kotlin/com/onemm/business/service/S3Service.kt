package com.onemm.business.service

import com.amazonaws.HttpMethod
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest
import com.onemm.common.config.S3Config
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.io.Serializable
import java.util.*


@Service
@Component
class S3Service(
    private val s3Config: S3Config,
    @Value("\${cloud.aws.s3.bucket}")
    private val bucket: String
) {

    fun getPreSignedUrl(folder: String, fileName: String): String {
        val encodedFileName = "${fileName}"
//      s3에 실제 저장될 경로
        val objectKey = "${folder}/${encodedFileName}"

        val expiration = Date()
        var expTimeMillis: Long = expiration.time
        expTimeMillis += (3 * 60 * 1000).toLong() // 3분
        expiration.time = expTimeMillis // url 만료 시간 설정

        val generatePresignedUrlRequest: GeneratePresignedUrlRequest =
            GeneratePresignedUrlRequest(bucket, objectKey)
                .withMethod(HttpMethod.PUT)
                .withExpiration(expiration)

        return s3Config.amazonS3Client().generatePresignedUrl(generatePresignedUrlRequest).toString()
    }


    fun downloadPreSignedUrl(folder: String, fileName: String): Map<String, Serializable>? {
        val encodedFileName = "${fileName}"
//        _${LocalDateTime.now()}
//      s3에 실제 저장될 경로
        val objectKey = "${folder}/${encodedFileName}"

        val expiration = Date()
        var expTimeMillis: Long = expiration.time
        expTimeMillis += (3 * 60 * 1000).toLong() // 3분
        expiration.time = expTimeMillis // url 만료 시간 설정

        val generatePresignedUrlRequest: GeneratePresignedUrlRequest =
            GeneratePresignedUrlRequest(bucket, objectKey)
                .withMethod(HttpMethod.GET)
                .withExpiration(expiration)

        return mapOf(
            "preSignedUrl" to s3Config.amazonS3Client().generatePresignedUrl(generatePresignedUrlRequest),
            "encodedFileName" to encodedFileName
        )
    }


}