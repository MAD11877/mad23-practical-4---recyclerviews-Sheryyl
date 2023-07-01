package com.example.mad_wk4prac;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public User(){}

    public User(String name, String description, int id, boolean followed){
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
