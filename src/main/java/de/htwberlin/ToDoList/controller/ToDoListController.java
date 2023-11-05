package de.htwberlin.ToDoList.controller;



import de.htwberlin.ToDoList.model.ToDoList;
import de.htwberlin.ToDoList.model.ToDoListManipulationCreatRequest;
import de.htwberlin.ToDoList.service.ToDoListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@RestController
public class ToDoListController {

    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping(path= "/api/a1/todolists")
    public ResponseEntity<List<ToDoList>> fetchTodoList(){
        return ResponseEntity.ok(toDoListService.findAll());
    }

    @GetMapping(path= "/api/a1/todolists/{id}")
    public  ResponseEntity fetchTodDoListByID(@PathVariable Long id){
        var toDoList= toDoListService.findById(id);
        return  toDoList != null? ResponseEntity.ok(toDoList): ResponseEntity.notFound().build();
    }


    @PostMapping(path= "/api/a1/todolists")
    public ResponseEntity<Void> createToDoList(@RequestBody ToDoListManipulationCreatRequest request) throws URISyntaxException {
        var toDoList =toDoListService.create(request);
        URI url= new URI("/api/a1/todolist" + toDoList.getId());
        return ResponseEntity.created(url).build();
    }

    @PutMapping("/api/a1/todolists/{id}")
    public ResponseEntity<ToDoList> updateTodoList(@PathVariable Long id, @RequestBody ToDoListManipulationCreatRequest request){
        var toDoList = toDoListService.update(id, request);
        return  toDoList != null? ResponseEntity.ok(toDoList): ResponseEntity.notFound().build();
    }
    @DeleteMapping("/api/a1/todolists/{id}")
    public ResponseEntity<Void> updateTodoList(@PathVariable Long id){
        boolean successful = toDoListService.deleteById(id);
        return  successful? ResponseEntity.ok().build(): ResponseEntity.notFound().build();
    }

}
