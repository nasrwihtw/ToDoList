package de.htwberlin.ToDoList.service;

import de.htwberlin.ToDoList.api.Task;
import de.htwberlin.ToDoList.api.TaskManipulationCreateRequest;
import de.htwberlin.ToDoList.persistence.TaskEntity;
import de.htwberlin.ToDoList.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    public TaskService(TaskRepository toDo){
        this.taskRepository =toDo;
    }
    public List<Task> findAll(){
        List<TaskEntity> toDoLists= taskRepository.findAll();
        return toDoLists.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Task findById(Long id){
        var taskEntity = taskRepository.findById(id);
        return taskEntity.map(this::transformEntity).orElse(null);
    }
    public Task create(TaskManipulationCreateRequest request){

        var taskEntity = new TaskEntity(request.getTitle(),request.getCompleted(), request.getPriority(), request.getDueDate(), request.getNotes());
        taskEntity = taskRepository.save(taskEntity);
        return transformEntity(taskEntity);
    }

    public Task update(Long id, TaskManipulationCreateRequest request){
        var taskEntityOptional = taskRepository.findById(id);
        if(taskEntityOptional.isEmpty()){
            return null;
        }
        var taskEntity= taskEntityOptional.get();
        taskEntity.setTitle(request.getTitle());
        taskEntity.setCompleted(request.getCompleted());
        taskEntity.setPriority(request.getPriority());
        taskEntity.setDueDate(request.getDueDate());
        taskEntity.setNotes(request.getNotes());
        taskEntity = taskRepository.save(taskEntity);


        return transformEntity(taskEntity);
    }
    public boolean deleteById(Long id){
        if (!taskRepository.existsById(id)){
            return false;
        }
        taskRepository.deleteById(id);
        return true;
    }

    private Task transformEntity(TaskEntity taskEntity) {
        List<TaskEntity> toDoLists= taskRepository.findAll();
        return new Task(
                        taskEntity.getId(),
                        taskEntity.getTitle(),
                        taskEntity.getCompleted(),
                        taskEntity.getPriority(),
                        taskEntity.getDueDate(),
                        taskEntity.getNotes()
                );
    }
}
