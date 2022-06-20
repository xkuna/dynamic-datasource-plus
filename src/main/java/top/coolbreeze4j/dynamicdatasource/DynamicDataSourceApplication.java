package top.coolbreeze4j.dynamicdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import top.coolbreeze4j.dynamicdatasource.test.service.TestService;
import top.coolbreeze4j.dynamicdatasource.utils.SpringUtils;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan(basePackages = {"top.coolbreeze4j.**.mapper"},sqlSessionTemplateRef = "sqlSessionTemplate")
public class DynamicDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDataSourceApplication.class, args);
    }

}
