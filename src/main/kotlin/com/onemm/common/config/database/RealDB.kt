package com.onemm.common.config.database

import com.onemm.common.annotation.Real
import com.onemm.common.config.database.DatabaseConfig.Companion.BASE_PACKAGE
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
@MapperScan(
    basePackages = ["$BASE_PACKAGE.real"],
    annotationClass = Real::class,
    sqlSessionFactoryRef = "realSqlSessionFactory"
)
class RealDB(applicationContext: ApplicationContext) : DatabaseConfig(applicationContext) {

    @Bean("realDataSource")
    @ConfigurationProperties(prefix = "$BASE_DATASOURCE.real")
    override fun dataSource() = super.dataSource()

    @Bean("realSqlSessionFactory")
    override fun sqlSessionFactory(realDataSource: DataSource) = super.sqlSessionFactory(realDataSource)

    @Bean("realSqlSessionTemplate")
    override fun sqlSessionTemplate(realSqlSessionFactory: SqlSessionFactory) =
        super.sqlSessionTemplate(realSqlSessionFactory)

}
