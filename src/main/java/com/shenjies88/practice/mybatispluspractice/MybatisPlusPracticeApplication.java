package com.shenjies88.practice.mybatispluspractice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shenjies88.practice.mybatispluspractice.mapper")
public class MybatisPlusPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusPracticeApplication.class, args);
	}

}
