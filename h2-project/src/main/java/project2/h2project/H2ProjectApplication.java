package project2.h2project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class H2ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(H2ProjectApplication.class, args);
    }

     @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){//Controller'da inject edebilmesi için bu bean'i ekledik
     RestTemplate restTemplate=builder.build();
        return restTemplate;
     }
}
