package com.gamingroom;

public class Entity {

    // private attributes
    private long id;
    private String name;

    // constructor
    private Entity() {
    }

    // custom constructor
    public Entity(long id, String name) {
        this(); 
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "Entity [id=" + id + ", name=" + name + "]";
    }
}
