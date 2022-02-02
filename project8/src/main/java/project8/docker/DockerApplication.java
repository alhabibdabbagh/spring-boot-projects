package project8.docker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import project8.docker.model.Course;
import project8.docker.model.Employee;
import project8.docker.repository.EmployeeRepository;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class DockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            Employee employee = new Employee("habib", 25, 25000.0,
                    Arrays.asList(new Course("java", LocalDate.of(2022, 02, 02)),
                            new Course("C#", LocalDate.of(2021, 02, 01)))
                    , Employee.Gender.MALE, 111111L);
            employeeRepository.insert(employee);
        };
    }

}
