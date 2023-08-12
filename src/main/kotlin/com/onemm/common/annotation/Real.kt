package com.onemm.common.annotation

import org.springframework.stereotype.Repository

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Repository
annotation class Real
