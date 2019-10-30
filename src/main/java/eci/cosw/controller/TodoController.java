package eci.cosw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eci.cosw.model.Todo;
import eci.cosw.model.User;
import eci.cosw.services.TodoService;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "*")
public class TodoController {

    @Autowired
    private TodoService TodoService;

    @GetMapping
    public ResponseEntity<?> getTodos() {
        try {
            return new ResponseEntity<>(TodoService.getTodosList(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(TodoService.getTodo(id), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/todoUser/{userID}")
    public ResponseEntity<?> getTodosByUserId(@PathVariable("userID") String userID) {
        try {

            return new ResponseEntity<>(TodoService.getTodosByUserId(userID), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTodoHandler(@RequestBody Todo Todo) {
        try {
            return new ResponseEntity<>(TodoService.createTodo(Todo), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateTask")
    public ResponseEntity<?> updateTodo(@RequestBody Todo Todo) {
        try {
            return new ResponseEntity<>(TodoService.updateTodo(Todo), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/assign/{TodoID}")
    public ResponseEntity<?> assignTodo(@PathVariable("TodoID") String TodoID, @RequestBody User user) {
        try {
            return new ResponseEntity<>(TodoService.assignTodoToUser(TodoID, user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable String id) {
        try {
            TodoService.removeTodo(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}