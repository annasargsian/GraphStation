package com.company;

import java.util.*;

public class NavigationMap {

    static HashMap<String, Set<Neighbour>> map = new HashMap<>();

    public void addStation(Station station) {
        map.put(station.getName(), new HashSet<>());
        System.out.println("Adding station is successfully");
    }

    public void addLength(Station station, Station secondStation, int length) {
        if (!map.containsKey(station.getName())) {
            map.put(station.getName(), new HashSet<>());
        }
        map.get(station.getName()).addAll(Arrays.asList(new Neighbour(secondStation.getName(), length)));
    }


    public void shortPath(String station, String secondStation) {
        Map<String, ShortestPath> shortestPathMap = dijkstra(map, station);
        shortestPathMap.get(secondStation).print();
    }


    public static Map<String, NavigationMap.ShortestPath> dijkstra(HashMap<String, Set<Neighbour>> nodes, String source) {
        Map<String, NavigationMap.ShortestPath> visited = new HashMap<>();
        PriorityQueue<Station> unvisited = new PriorityQueue<>(Comparator.comparingInt((station) -> station.getDistance()));
        nodes.forEach((name, neighbours) -> {
            Station station;
            if (name.equals(source)) {
                station = new Station(name, 0, neighbours, new ArrayList<>(Collections.singletonList(name)));
            } else {
                station = new Station(name, Integer.MAX_VALUE, neighbours);
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
                            currentNeighbour.setPath(new ArrayList<>(current.getPath()));
                            currentNeighbour.getPath().add(neighbour.getName());
                        }
                        unvisited.add(currentNeighbour);
                        break;
                    }
                }
            }

            ShortestPath shortestPath = new ShortestPath(source, current.getName(), current.getDistance(), current.getPath());
            visited.put(current.getName(), shortestPath);
            current = unvisited.poll();

        }
        return visited;

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