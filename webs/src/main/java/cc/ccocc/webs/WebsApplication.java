package cc.ccocc.webs;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication(scanBasePackages = {"cc.ccocc.service","cc.ccocc.dao","cc.ccocc.pojo","cc.ccocc.webs.controller"})
@MapperScan(basePackages = "cc.ccocc.dao",basePackageClasses = Repository.class)
public class WebsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsApplication.class, args);
    }

}
