package de.htwberlin.ToDoList.repository;

import de.htwberlin.ToDoList.model.ToDoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends CrudRepository<ToDoList, Long> {



}
