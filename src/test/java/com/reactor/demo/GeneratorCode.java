package com.reactor.demo;

import com.reactor.demo.util.MysqlGenerator;
import org.junit.jupiter.api.Test;


public class GeneratorCode {

    @Test
    void run() {
        MysqlGenerator mysqlGenerator = new MysqlGenerator();
        mysqlGenerator.generator("com.reactor.demo", "", "reactor-demo", "product");
    }
}