package org.xjosiah.mylittleairplay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.xjosiah.mylittleairplay.mybatis.mapper")
@SpringBootApplication
public class MyLittleAirplayBackendApplication {

    public static void main(String[] args){
        SpringApplication.run(MyLittleAirplayBackendApplication.class, args);
    }

}
