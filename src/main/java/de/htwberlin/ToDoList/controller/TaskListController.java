package de.htwberlin.ToDoList.controller;


import de.htwberlin.ToDoList.model.TaskList;
import de.htwberlin.ToDoList.model.TaskListManipulationCreateRequest;
import de.htwberlin.ToDoList.service.TaskListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin
public class TaskListController {
    private final TaskListService taskListService;

    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @GetMapping(path= "/api/a1/taskList")
    public ResponseEntity<List<TaskList>> fetchTaskList(){
        return ResponseEntity.ok(taskListService.findAll());
    }

    @GetMapping(path= "/api/a1/taskList/{id}")
    public  ResponseEntity fetchListTaskByID(@PathVariable Long id){
        var task= taskListService.findById(id);
        return  task != null? ResponseEntity.ok(task): ResponseEntity.notFound().build();
    }


    @PostMapping(path= "/api/a1/taskList")
    public ResponseEntity<Void> createTaskList(@RequestBody TaskListManipulationCreateRequest request) throws URISyntaxException {
        var taskList = taskListService.create(request);
        URI url= new URI("/api/a1/task" + taskList.getId());
        return ResponseEntity.created(url).build();
    }

    @PutMapping("/api/a1/taskList/{id}")
    public ResponseEntity<TaskList> updateTaskList(@PathVariable Long id, @RequestBody TaskListManipulationCreateRequest request){
        var taskList = taskListService.update(id, request);
        return  taskList != null? ResponseEntity.ok(taskList): ResponseEntity.notFound().build();
    }
    @DeleteMapping("/api/a1/taskList/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable Long id){
        boolean successful = taskListService.deleteById(id);
        return  successful? ResponseEntity.ok().build(): ResponseEntity.notFound().build();
    }

}

