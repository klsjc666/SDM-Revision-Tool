package org.SDM;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan({"org.SDM.**.mapper"})
@ComponentScan({"org.SDM.**"})
@ServletComponentScan
public class APP {
    public static void main(String[] args) {
        SpringApplication.run(APP.class, args);
    }
}