package project8.docker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project8.docker.model.Employee;

/**
 * @author Habib
 * @on 2/2/22 - 7:58 PM
 */
public interface EmployeeRepository extends MongoRepository<Employee,String> {
}
