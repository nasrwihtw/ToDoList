package de.htwberlin.ToDoList.persistence;

import jakarta.persistence.*;
@Entity(name= "TaskList")
public class TaskListEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Long id;
        @Column(name="name", nullable = false)
        private String name;

        @Column(name="owner" , nullable = false)
        private String owner;

    public TaskListEntity(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    protected TaskListEntity() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
