package com.excrispy.moviecatalogservice.models;

public class Movie {
    String id;
    String name;
    String type;

    public Movie() {}

    public Movie(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
