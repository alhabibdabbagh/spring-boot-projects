package project7.security7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.mappers.ModelMapper;

@SpringBootApplication
@EnableSwagger2
public class Security7Application {

    public static void main(String[] args) {
        SpringApplication.run(Security7Application.class, args);
    }


}
