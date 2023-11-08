package de.htwberlin.ToDoList.repository;


import de.htwberlin.ToDoList.persistence.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
List<TaskEntity> findByTitle(String title);


}
