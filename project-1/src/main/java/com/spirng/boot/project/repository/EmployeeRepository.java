package com.spirng.boot.project.repository;

import com.spirng.boot.project.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employee,Integer> {
    @Query("select count(e) from Employee as e ")
    int getAllEmployeeCount ();

    //@Query(nativeQuery = true)
    @Query("select e.age as age ,count(e.age) as count from Employee as e GROUP BY e.age") // burada as count as age önemli mapplema için
    List<GroupWithAgeAndCount> getGroup();

    @Query("select e.age as age ,count(e.age) as Count from Employee as e GROUP BY e.age")
    List<?> getGroupWith();
}