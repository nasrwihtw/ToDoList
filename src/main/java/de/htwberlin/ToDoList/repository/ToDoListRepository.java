package de.htwberlin.ToDoList.repository;


import de.htwberlin.ToDoList.persistence.TodDoListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<TodDoListEntity, Long> {
List<TodDoListEntity> findByTitle(String title);


}
