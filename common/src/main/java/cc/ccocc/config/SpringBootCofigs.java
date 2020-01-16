package cc.ccocc.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created on 22:45  14/01/2020
 * Description:
 *  springboot的配置类
 * @author Weleness
 */

@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement // 开启spring 声明式事务注解支持
@EnableAspectJAutoProxy // 开始aop注解支持
@SpringBootConfiguration // 声明为springboot的配置类
public class SpringBootCofigs {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    /**
     * @Method
     * Description:
     *  配置hikari数据源，交给spring管理，让mybatis使用这个数据源
     * @Author weleness
     *
     * @Return
     */
    @Bean("dataSource")
    public DataSource hikariDataSource(){
        HikariDataSource hd = new HikariDataSource();

        hd.setDriverClassName(driver);
        hd.setJdbcUrl(url);
        hd.setUsername(user);
        hd.setPassword(password);
        return hd;
    }



}
