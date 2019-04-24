package com.example.springfreemaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 参考：Spring Boot 2.0 整合 FreeMarker 模板引擎,https://www.cnblogs.com/xingyunblog/p/8746542.html
 */
@SpringBootApplication
@EnableJpaRepositories
public class SpringFreemakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFreemakerApplication.class, args);
	}

}
