package com.onemm.common.exception

import org.springframework.http.HttpStatus

enum class CommonError(val tag: String, private val code: String, private val httpStatus: HttpStatus) : Error {

    ERROR("실패", "100000", HttpStatus.INTERNAL_SERVER_ERROR),
    AUTHENTICATION("유저 없음", "100001", HttpStatus.NOT_FOUND),
    BAD_REQUEST("요청 실패", "100002", HttpStatus.BAD_REQUEST),

    ;


    override fun key(): String = name

    override fun code(): String = code

    override fun httpStatus(): HttpStatus = httpStatus


}
