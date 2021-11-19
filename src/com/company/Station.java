package com.company;

import java.util.Random;

public class Station {
    private String name;
    private static Random id;
    
    public Station(String name, Random id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Random getId() {
        return id;
    }

    public void setId(Random id) {
        this.id = id;
    }
}
