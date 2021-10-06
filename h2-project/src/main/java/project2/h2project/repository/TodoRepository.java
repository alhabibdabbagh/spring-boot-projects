package project2.h2project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project2.h2project.entity.Todo;
@Repository
public interface TodoRepository extends CrudRepository<Todo,Integer> {
}
