package de.htwberlin.ToDoList.model;

public class TaskListManipulationCreateRequest {
    private String name;
    private String owner;

    public TaskListManipulationCreateRequest(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }
}
