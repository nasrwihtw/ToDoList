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
    @Column(name="dueDate" , nullable = false)
    private String dueDate;
    @Column(name="completed")
    private String completed;

    public TaskEntity(String title, String dueDate, String completed) {
        this.title = title;
        this.dueDate = dueDate;
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }
}
