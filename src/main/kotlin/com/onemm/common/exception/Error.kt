package com.onemm.common.exception

import org.springframework.http.HttpStatus

interface Error {

    fun key(): String
    fun code(): String
    fun httpStatus(): HttpStatus

}
