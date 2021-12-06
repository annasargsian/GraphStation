package com.company;

import java.util.ArrayList;
import java.util.Set;

public class Station {
    private String name;
    private int distance;
    private Set<Neighbour> neighbours;
    private ArrayList<String> path;

    public Station(String name, int distance, Set<Neighbour> neighbours, ArrayList<String> path) {
        this.name = name;
        this.distance = distance;
        this.neighbours = neighbours;
        this.path = path;
    }

    public Station(String name, int distance, Set<Neighbour> neighbours) {
        this.name = name;
        this.distance = distance;
        this.neighbours = neighbours;
    }

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public Set<Neighbour> getNeighbours() {
        return neighbours;
    }

    public ArrayList<String> getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setNeighbours(Set<Neighbour> neighbours) {
        this.neighbours = neighbours;
    }

    public void setPath(ArrayList<String> path) {
        this.path = path;
    }
}
