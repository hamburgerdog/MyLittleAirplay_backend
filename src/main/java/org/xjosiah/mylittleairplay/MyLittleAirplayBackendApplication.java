package org.xjosiah.mylittleairplay;

import cn.hutool.json.JSONUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.xjosiah.mylittleairplay.mybatis.mapper.AlbumMapper;
import org.xjosiah.mylittleairplay.utils.db.CreateTable;

import java.io.IOException;

@MapperScan("org.xjosiah.mylittleairplay.mybatis.mapper")
@SpringBootApplication
public class MyLittleAirplayBackendApplication {

    public static void main(String[] args){
        SpringApplication.run(MyLittleAirplayBackendApplication.class, args);
    }

}
