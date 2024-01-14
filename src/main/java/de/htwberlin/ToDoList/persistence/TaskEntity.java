package de.htwberlin.ToDoList.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @Column(name="priority")
    private Priority priority;
    @Column(name="datum")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @Column(name="notes")
    private String notes;



    public TaskEntity(String title, boolean completed, Priority priority, LocalDate dueDate,String notes) {
        this.title = title;
        this.completed = completed;
        this.priority= priority;
        this.dueDate=dueDate;
        this.notes=notes;

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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;

    }
    public void setId(Long taskId) {
        this.id = taskId;
    }
}
