package de.htwberlin.ToDoList.model;

public class ToDoListManipulationCreatRequest {
    private String title;
    private String dueDate;
    private String completed;

    public ToDoListManipulationCreatRequest(String title, String dueDate, String completed) {
        this.title = title;
        this.dueDate = dueDate;
        this.completed = completed;
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
