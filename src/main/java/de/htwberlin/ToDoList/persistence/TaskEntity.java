package de.htwberlin.ToDoList.persistence;

import jakarta.persistence.*;

@Entity(name= "Task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="completed")
    private boolean completed;


    public TaskEntity(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    protected TaskEntity() {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setId(Long taskId) {
    }
}
