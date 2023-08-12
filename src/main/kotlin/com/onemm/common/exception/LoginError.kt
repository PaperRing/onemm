package com.onemm.common.exception

import org.springframework.http.HttpStatus

enum class LoginError(val tag: String, private val code: String, private val httpStatus: HttpStatus) : Error {
    SEARCH_ERROR("로그인 실패", "200000", HttpStatus.NOT_FOUND),
    ;


    override fun key(): String = name

    override fun code(): String = code

    override fun httpStatus(): HttpStatus = httpStatus
}