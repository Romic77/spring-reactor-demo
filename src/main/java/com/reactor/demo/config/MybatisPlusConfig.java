package com.reactor.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author romic
 */
@Slf4j
@Configuration
@EnableTransactionManagement
@MapperScan("com.reactor.**.mapper.**")
public class MybatisPlusConfig {

}