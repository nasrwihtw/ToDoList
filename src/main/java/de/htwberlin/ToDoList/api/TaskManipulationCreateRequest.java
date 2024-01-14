package de.htwberlin.ToDoList.api;

import de.htwberlin.ToDoList.persistence.Priority;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskManipulationCreateRequest {
    @NotBlank( message = "please provide a task")
    private String title;
    private boolean completed;
    private Priority priority;
    private LocalDate dueDate;
    private String notes;


    public TaskManipulationCreateRequest(String title, boolean completed, Priority priority, LocalDate dueDate , String notes) {
        this.title = title;
        this.completed = completed;
        this.priority= priority;
        this.dueDate=dueDate;
        this.notes = notes;
    }

    public TaskManipulationCreateRequest() {
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
    public LocalDate getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
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
}
