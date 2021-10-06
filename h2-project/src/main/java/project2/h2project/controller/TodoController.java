package project2.h2project.controller;

import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import project2.h2project.entity.Todo;
import project2.h2project.repository.TodoRepository;

import java.time.LocalDateTime;

/**
 * @author Habib
 * @on 10/5/21 - 11:48 PM
 */
@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/get/{id}")
    public ResponseEntity<Todo> getjsonFromRemoteTodoList(@PathVariable int id){
      Todo todo=restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/"+id,Todo.class);
        todo.setLocalDateTime(LocalDateTime.now());
        todoRepository.save(todo);
      return new ResponseEntity<> (todo, HttpStatus.OK);
    }
    @GetMapping("/get/str/{id}")
    public ResponseEntity<String> getjsonFromRemoteTodoListWithString(@PathVariable int id){
        ResponseEntity<String>  todo=restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/"+id, String.class);
        return todo;
    }
}
