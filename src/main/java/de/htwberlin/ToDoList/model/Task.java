package de.htwberlin.ToDoList.model;


public class Task {


    private Long id;
    private String title;

    private boolean completed;

    public Task(Long id, String title, boolean completed) {

        this.title = title;

        this.completed = completed;
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
}
