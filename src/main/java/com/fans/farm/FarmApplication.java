package com.fans.farm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.fans.farm.mapper")
@SpringBootApplication
@ServletComponentScan
public class FarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmApplication.class, args);
	}
}
