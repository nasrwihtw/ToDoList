package de.htwberlin.ToDoList.service;


import de.htwberlin.ToDoList.model.TaskList;
import de.htwberlin.ToDoList.model.TaskListManipulationCreateRequest;
import de.htwberlin.ToDoList.persistence.TaskListEntity;
import de.htwberlin.ToDoList.repository.TaskListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskListService {

    private TaskListRepository taskListRepository;
    public TaskListService(TaskListRepository taskListRepository){
        this.taskListRepository =taskListRepository;
    }
    public List<TaskList> findAll(){
        List<TaskListEntity> taskList= taskListRepository.findAll();
        return taskList.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }


    public TaskList findById(Long id){
        var taskListEntity = taskListRepository.findById(id);
        return taskListEntity.map(this::transformEntity).orElse(null);
    }
    public TaskList create(TaskListManipulationCreateRequest request){

        var taskListEntity = new TaskListEntity(request.getName(), request.getOwner());
        taskListEntity = taskListRepository.save(taskListEntity);
        return transformEntity(taskListEntity);
    }
    public TaskList update(Long id, TaskListManipulationCreateRequest request){
        var taskListEntityOptional = taskListRepository.findById(id);
        if(taskListEntityOptional.isEmpty()){
            return null;
        }
        var taskListEntity= taskListEntityOptional.get();
        taskListEntity.setName(request.getName());
        taskListEntity.setOwner(request.getOwner());

        return transformEntity(taskListEntity);
    }
    public boolean deleteById(Long id){
        if (!taskListRepository.existsById(id)){
            return false;
        }
        taskListRepository.deleteById(id);
        return true;
    }
    private TaskList transformEntity(TaskListEntity taskListEntity) {
        List<TaskListEntity> taskList= taskListRepository.findAll();
        return new TaskList(
                taskListEntity.getId(),
                taskListEntity.getName(),
                taskListEntity.getOwner()
        );
    }


}
