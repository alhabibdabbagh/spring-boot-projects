package project7.security7.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Habib
 * @on 11/15/21 - 2:02 PM
 */
@Configuration
public class DataSourceConfiguration {
// bu da farklı yöntem application properties kullanmadan çağıryabiliyoruz
     @Bean
     @Primary
    public DataSource h2DataSource(){
         DataSourceBuilder dataSourceBuilder=DataSourceBuilder.create();
         dataSourceBuilder.driverClassName("org.h2.Driver");
         dataSourceBuilder.username("sa");
         dataSourceBuilder.password("password");
         dataSourceBuilder.url("jdbc:h2:mem:testdb");
          return  dataSourceBuilder.build();
     }
     @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource(){
         DataSourceBuilder dataSourceBuilder=DataSourceBuilder.create();
         dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
         dataSourceBuilder.username("root");
         dataSourceBuilder.password("123asdF!,");
         dataSourceBuilder.url("jdbc:mysql://localhost:3306/employee?characterEncoding=utf8&useSSL=false");
         return  dataSourceBuilder.build();
     }

}
