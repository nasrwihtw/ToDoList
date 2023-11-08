package de.htwberlin.ToDoList.model;

public class TaskList {
    private long id;
    private String name;

    private String owner;

    public TaskList(Long id, String name, String owner) {

        this.name = name;
        this.owner = owner;
    }

    public long getId() {
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
