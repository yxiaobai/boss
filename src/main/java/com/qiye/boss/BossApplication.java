package com.qiye.boss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.qiye.boss.mapper")
@EnableScheduling
public class BossApplication {

	public static void main(String[] args) {
		SpringApplication.run(BossApplication.class, args);
	}

}
