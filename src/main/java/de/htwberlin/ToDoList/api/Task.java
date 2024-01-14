package de.htwberlin.ToDoList.api;

import de.htwberlin.ToDoList.persistence.Priority;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Task {


    private Long id;
    private String title;
    private boolean completed;
    private Priority priority;
    private LocalDate dueDate;
    private String notes;

    public Task(Long id, String title, boolean completed, Priority priority, LocalDate dueDate , String notes) {
        this.id= id;
        this.title = title;
        this.completed = completed;
        this.priority= priority;
        this.dueDate=dueDate;
        this.notes = notes;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public void setDueDate(LocalDate deadline) {
        this.dueDate = deadline;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
