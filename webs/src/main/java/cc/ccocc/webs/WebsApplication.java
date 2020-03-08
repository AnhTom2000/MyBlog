package cc.ccocc.webs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = {"cc.ccocc.service","cc.ccocc.dao","cc.ccocc.pojo","cc.ccocc.webs.controller","cc.ccocc.config","cc.ccocc.webs.exceptionHandler","cc.ccocc.webs.aop"})
@MapperScan(basePackages = "cc.ccocc.dao",basePackageClasses = Repository.class)
public class WebsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsApplication.class, args);
    }

}
