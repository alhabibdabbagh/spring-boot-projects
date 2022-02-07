package project8.docker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import project8.docker.model.Employee;

import java.util.List;
import java.util.Optional;

/**
 * @author Habib
 * @on 2/2/22 - 7:58 PM
 */
public interface EmployeeRepository extends MongoRepository<Employee,String> {
 //   List<Employee> findEmployeeBySsid(Long ssid);

    @Query("{'fullName' : ?0 , 'age' : ?1 }")
    Employee findEmployeeByFullNameAndAge(String fullName,int age);
}
