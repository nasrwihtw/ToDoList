package de.htwberlin.ToDoList.model;

public class TaskManipulationCreateRequest {
    private String title;
    private boolean completed;

    public TaskManipulationCreateRequest(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
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
}
