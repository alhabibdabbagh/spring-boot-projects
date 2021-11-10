package project7.security7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Habib
 * @on 11/10/21 - 11:28 AM
 */
@Configuration
public class CustomerConfiguration implements WebMvcConfigurer { //interface segration SOLİD

    @Bean
    public CustomerInterceptor getInterceptor(){
        return new CustomerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor()).addPathPatterns("/**"); //hangi durumlarda devreye girecek
    }
}
