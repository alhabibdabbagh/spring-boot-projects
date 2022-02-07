package project8.docker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import project8.docker.model.Course;
import project8.docker.model.Employee;
import project8.docker.repository.EmployeeRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@SpringBootApplication
public class DockerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DockerApplication.class, args);
    }

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee("habib12", 24, 25000.0,
                Arrays.asList(new Course("java11", LocalDate.of(2022, 02, 02)),
                        new Course("C#1", LocalDate.of(2021, 02, 01)))
                , Employee.Gender.MALE, 11332231121211L);

/*
        if (!employeeRepository.findEmployeeBySsid(employee.getSsid()).isEmpty()) {
            log.info("this Employee " + employee.getSsid() + "is already ");
        } else {
            log.info("new Employee added ");
            employeeRepository.insert(employee);
        }*/

//DİFFERENT WAY WİTH QUERY
        if (Objects.nonNull(employeeRepository.findEmployeeByFullNameAndAge("habib12",24))) {
            log.info("this Employee " + employee.getSsid() + " is already ");
        } else {
            log.info("new Employee added ");
            employeeRepository.insert(employee);
        }



        //different Way
       /* Query query = new Query();
        query.addCriteria(Criteria.where("ssid").is(employee.getSsid()));

        List<Employee> employeeList = mongoTemplate.find(query, Employee.class);
        for (Employee employee1 : employeeList) {
            log.info(String.valueOf(employee));
        }

        if(employeeList.isEmpty()){
            log.info("new Employee added ");
            employeeRepository.insert(employee);
        }else {
            log.info("this Employee "+ employee.getSsid() +"is already ");
        }*/

        //  employeeRepository.insert(employee);
    }

 /*   @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            Employee employee = new Employee("habib", 25, 25000.0,
                    Arrays.asList(new Course("java", LocalDate.of(2022, 02, 02)),
                            new Course("C#", LocalDate.of(2021, 02, 01)))
                    , Employee.Gender.MALE, 111111L);
            employeeRepository.insert(employee);
        }; //TODO we can write this with CommendLineRunner implemention
    }*/

}
