package com.qgzx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

/**
 * ClassName: QgzxApplication <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2017年9月12日 上午10:33:23 <br/>
 *
 * @author zhangzhengan
 * @since JDK 1.7
 */
@SpringBootApplication@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@MapperScan(basePackages = "com.qgzx.mapper")
@EnableOpenApi
//启动swagger注解 启动服务，浏览器输入"http://服务名:8080/swagger-ui.html"
public class QgzxApplication {
    public static void main(String[] args) {
        SpringApplication.run(QgzxApplication.class, args);
    }

}
