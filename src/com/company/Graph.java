package com.company;

import java.util.*;
import java.util.function.BiConsumer;

public class Graph {

    static HashMap<String, Set<Neighbour>> map = new HashMap<>();
    Station station;

        public void addStation(Station station) {
            map.put(station.name,new HashSet<>());
            System.out.println("Adding station is successfully");
        }

        public void addLength(Station station,Station secondStation, int length){
            if (!map.containsKey(station)) {
                map.put(station.name, new HashSet<>());
            }
            map.get(station.name).addAll(Arrays.asList(new Neighbour(secondStation.getName(), length)));
        }

        public void shortPath(String station,String secondStation){
            Map<String, ShortestPath> shortestPathMap  =  dijkstra(map,station);
            shortestPathMap.get(secondStation).print();
        }



    public static Map<String, Graph.ShortestPath> dijkstra(Map<String, Set<Graph.Neighbour>> nodes, String source) {
        Map<String, Graph.ShortestPath> visited = new HashMap<>();
        PriorityQueue<Graph.Station> unvisited = new PriorityQueue<>(Comparator.comparingInt((station) -> station.distance));
        nodes.forEach((name, neighbours) -> {
            Graph.Station station;
            if (name.equals(source)) {
                station = new Graph.Station(name, 0, neighbours, new ArrayList<>(Collections.singletonList(name)));
            } else {
                station = new Graph.Station(name, Integer.MAX_VALUE, neighbours);
            }
            unvisited.add(station);
        });


        Station current = unvisited.poll();
        while (current != null) {
            for (Neighbour neighbour : current.getNeighbours()) {
                Iterator<Station> itr = unvisited.iterator();
                while (itr.hasNext()) {
                    Station currentNeighbour = itr.next();
                    if (currentNeighbour.getName().equals(neighbour.getName())) {
                        itr.remove();
                        if (current.getDistance() + neighbour.getDistance() < currentNeighbour.getDistance()) {
                            currentNeighbour.setDistance(current.getDistance() + neighbour.getDistance());
                           ArrayList<String> newPath = new ArrayList<>(current.getPath());
                            newPath.add(neighbour.getName());
                            System.out.println(newPath);
                            currentNeighbour.setPath(new ArrayList<>(current.getPath()));
                        }
                        unvisited.add(currentNeighbour);
                        break;
                    }
                }
            }

            ShortestPath shortestPath = new ShortestPath(source, current.name, current.distance, current.path);
            visited.put(current.getName(), shortestPath);
            current = unvisited.poll();

        }
        return visited;

    }

    private static class Neighbour {
        private String name;
        private int distance;

        public Neighbour(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }

        public String getName() {
            return name;
        }

        public int getDistance() {
            return distance;
        }
    }

    public static class Station {
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
        public Station(String name){
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

    private static class ShortestPath {
        private String source;
        private String destination;
        private int distance;
        private ArrayList<String> path;


        public ShortestPath(String source, String destination, int distance, ArrayList<String> paths) {
            this.source = source;
            this.destination = destination;
            this.distance = distance;
            this.path = paths;
        }

        public void print() {
            String str = String.format("from %s to %s , the distance is %d , and path is %s", source, destination, distance, path.toString());
            System.out.println(str);
        }

    }
}