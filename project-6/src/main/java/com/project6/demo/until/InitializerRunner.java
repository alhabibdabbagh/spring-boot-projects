package com.project6.demo.until;

import com.project6.demo.entity.User;
import com.project6.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author Habib
 * @on 10/10/21 - 12:19 PM
 */
@Component
public class InitializerRunner implements CommandLineRunner {
    private final static Logger LOGGER = LoggerFactory.getLogger(InitializerRunner.class);


    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        //   userRepository.save(new User()); diffrenet way to definition
        userRepository.save(User.builder().age(23).email("334@gmail.com").name("dfs").build());
        userRepository.save(User.builder().age(44).email("1234@gmail.com").name("gg").build());
        userRepository.save(User.builder().age(56).email("123@gmail.com").name("asd").build());

        userRepository.save(User.builder().age(22).email("habib@gmail.com").name("habibbb").build()); // the sort not problem with constructor
        userRepository.findAll().forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                LOGGER.info("{}", user);
            }
        });
        userRepository.findAll().forEach(user -> LOGGER.info("{}",user));// differnet way
         LOGGER.info("Logg" + userRepository);
    }
    //bu şekilde initialize olmuş oldu


}
