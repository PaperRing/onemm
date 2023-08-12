package com.onemm.common.config.database

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import javax.sql.DataSource

@Configuration
@PropertySource("classpath:/application.yml")
abstract class DatabaseConfig(private val applicationContext: ApplicationContext) {

    companion object {
        const val BASE_PACKAGE = "com.onemm.business.mapper"
        const val BASE_DATASOURCE = "spring.datasource.hikari"
    }

    fun dataSource(): DataSource = DataSourceBuilder.create().build()

    fun sqlSessionFactory(dataSource: DataSource): SqlSessionFactory? {
        return SqlSessionFactoryBean().apply {
            setDataSource(dataSource)
            setTypeAliasesPackage("com.onemm.business.model")
            setMapperLocations(*applicationContext.getResources("classpath:/mapper/**/*.xml"))
            getObject()?.configuration?.isMapUnderscoreToCamelCase = true
            getObject()
        }.`object`
    }

    fun sqlSessionTemplate(sqlSessionFactory: SqlSessionFactory): SqlSessionTemplate =
        SqlSessionTemplate(sqlSessionFactory)

}
