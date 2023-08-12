package com.onemm.common.exception

import mu.KotlinLogging
import org.apache.commons.lang3.exception.ExceptionUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

private val log = KotlinLogging.logger {}

@ControllerAdvice
class ExceptionAdvice(private val slackService: SlackService) {

    private fun toResponseEntity(error: Error): ResponseEntity<Any> {
        val message = error.code()
        return ResponseEntity(
            mapOf("code" to error.code(), "key" to error.key(), "message" to message),
            error.httpStatus()
        )
    }


    @ExceptionHandler(value = [Exception::class])
    fun handler(e: Exception): ResponseEntity<Any> {
        log.error(ExceptionUtils.getStackTrace(e))
        return toResponseEntity(CommonError.ERROR)
    }

    @ExceptionHandler(NullPointerException::class)
    fun handler(e: NullPointerException): ResponseEntity<Any> {
        log.error(ExceptionUtils.getStackTrace(e))
        return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value = [LoginException::class])
    fun handler(e: LoginException): ResponseEntity<Any> {
        slackService.sendMessage("로그인 오류: ${e.error.code()}")
        return toResponseEntity(e.error)
    }

    @ExceptionHandler(value = [SearchException::class])
    fun handler(e: SearchException): ResponseEntity<Any> {
        slackService.sendMessage("검색 실패: ${e.error.code()}")
        return toResponseEntity(e.error)
    }

//    @ExceptionHandler(value = [ServiceException::class])
//    fun handler(e: ServiceException): ResponseEntity<Any> {
//        log.error("${e.error} (${e.error.code()})\n${ExceptionUtils.getStackTrace(e)}")
//        return toResponseEntity(e.error)
//    }


}
