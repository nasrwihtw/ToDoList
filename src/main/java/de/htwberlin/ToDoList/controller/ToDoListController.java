package de.htwberlin.ToDoList.controller;



import de.htwberlin.ToDoList.model.ToDoList;
import de.htwberlin.ToDoList.repository.ToDoListRepository;
import org.springframework.web.bind.annotation.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/api/a1/todolist")
@RestController
public class ToDoListController {
    @Autowired
    private ToDoListRepository toDo;
    @PostMapping
    public ToDoList addToDoList(@RequestBody ToDoList  toDoList){
        return toDo.save(toDoList);

    }
}
