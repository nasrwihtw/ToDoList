package de.htwberlin.ToDoList.controller;



import de.htwberlin.ToDoList.model.Task;
import de.htwberlin.ToDoList.model.TaskManipulationCreateRequest;
import de.htwberlin.ToDoList.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@CrossOrigin
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path= "/api/a1/task")
    public ResponseEntity<List<Task>> fetchTask(){
        List<Task> tasks = taskService.findAll();
        System.out.println("Fetched tasks: " + tasks);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping(path= "/api/a1/task/{id}")
    public  ResponseEntity fetchTaskByID(@PathVariable Long id){
        var task= taskService.findById(id);
        return  task != null? ResponseEntity.ok(task): ResponseEntity.notFound().build();
    }


    @PostMapping(path= "/api/a1/task")
    public ResponseEntity<Void> createTask(@RequestBody TaskManipulationCreateRequest request) throws URISyntaxException {
        var task = taskService.create(request);
        URI url= new URI("/api/a1/task" + task.getId());
        return ResponseEntity.created(url).build();
    }

    @PutMapping("/api/a1/task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskManipulationCreateRequest request){
        var task = taskService.update(id, request);
        return  task != null? ResponseEntity.ok(task): ResponseEntity.notFound().build();
    }
    @DeleteMapping("/api/a1/task/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable Long id){
        boolean successful = taskService.deleteById(id);
        return  successful? ResponseEntity.ok().build(): ResponseEntity.notFound().build();
    }

}
