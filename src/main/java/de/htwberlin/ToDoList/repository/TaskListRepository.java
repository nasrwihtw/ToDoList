package de.htwberlin.ToDoList.repository;


import de.htwberlin.ToDoList.persistence.TaskEntity;
import de.htwberlin.ToDoList.persistence.TaskListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskListRepository extends JpaRepository<TaskListEntity, Long> {
    List<TaskEntity> findByName(String name);
}
