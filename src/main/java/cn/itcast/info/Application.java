package cn.itcast.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
注意：引导类应放到项目父级目录下，负责注解无法被扫描到而报bean对象注入异常
*/
@SpringBootApplication
@EnableCaching  /*开启缓存*/
public class Application {
        public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        }
}
