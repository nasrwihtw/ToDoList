package de.htwberlin.ToDoList.service;

import de.htwberlin.ToDoList.model.ToDoList;
import de.htwberlin.ToDoList.model.ToDoListManipulationCreatRequest;
import de.htwberlin.ToDoList.persistence.TodDoListEntity;
import de.htwberlin.ToDoList.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoListService {
    private ToDoListRepository toDoListRepository;
    public ToDoListService(ToDoListRepository toDo){
        this.toDoListRepository =toDo;
    }
    public List<ToDoList> findAll(){
        List<TodDoListEntity> toDoLists= toDoListRepository.findAll();
        return toDoLists.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public ToDoList findById(Long id){
        var todDoListEntity = toDoListRepository.findById(id);
        return todDoListEntity.map(this::transformEntity).orElse(null);
    }
    public ToDoList create(ToDoListManipulationCreatRequest request){

        var todDoListEntity = new TodDoListEntity(request.getTitle(), request.getDueDate(), request.getCompleted());
        todDoListEntity = toDoListRepository.save(todDoListEntity);
        return transformEntity(todDoListEntity);
    }

    public ToDoList update(Long id, ToDoListManipulationCreatRequest request){
        var todDoListEntityOptional = toDoListRepository.findById(id);
        if(todDoListEntityOptional.isEmpty()){
            return null;
        }
        var toDoListEntity= todDoListEntityOptional.get();
        toDoListEntity.setTitle(request.getTitle());
        toDoListEntity.setDueDate(request.getDueDate());
        toDoListEntity.setCompleted(request.getCompleted());
        toDoListEntity =toDoListRepository.save(toDoListEntity);


        return transformEntity(toDoListEntity);
    }
    public boolean deleteById(Long id){
        if (!toDoListRepository.existsById(id)){
            return false;
        }
        toDoListRepository.deleteById(id);
        return true;
    }

    private ToDoList transformEntity(TodDoListEntity todDoListEntity) {
        List<TodDoListEntity> toDoLists= toDoListRepository.findAll();
        return new ToDoList(
                        todDoListEntity.getId(),
                        todDoListEntity.getTitle(),
                        todDoListEntity.getDueDate(),
                        todDoListEntity.getCompleted()
                );
    }
}
