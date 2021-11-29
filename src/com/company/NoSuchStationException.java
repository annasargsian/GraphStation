package com.company;

import java.util.*;

public class NoSuchStationException extends Throwable {
}
//    public static Map<String, Graph.ShortestPath> dijkstra(Map<String, Set<Graph.Neighbour>> nodes, String source) {
//        Map<String, Graph.ShortestPath> visited = new HashMap<>();
//        PriorityQueue<Graph.Station> unvisited = new PriorityQueue<>(Comparator.comparingInt((station) -> station.distance));
//        nodes.forEach((name, neighbours) -> {
//            Graph.Station station;
//            if (name.equals(source)) {
//                station = new Graph.Station(name, 0, neighbours, new ArrayList<>(Collections.singletonList(name)));
//            } else {
//                station = new Graph.Station(name, Integer.MAX_VALUE, neighbours);
//            }
//            unvisited.add(station);
//        });
//
//
//        Graph.Station current = unvisited.poll();
//        while (current != null) {
//            for (Graph.Neighbour neighbour : current.getNeighbours()) {
//                Iterator<Graph.Station> itr = unvisited.iterator();
//                while (itr.hasNext()) {
//                    Graph.Station currentNeighbour = itr.next();
//                    if (currentNeighbour.getName().equals(neighbour.getName())) {
//                        itr.remove();
//                        if (current.getDistance() + neighbour.getDistance() < currentNeighbour.getDistance()) {
//                            currentNeighbour.setDistance(current.getDistance() + neighbour.getDistance());
//                            ArrayList<String> newPath = new ArrayList<>(current.getPath());
//                            newPath.add(neighbour.getName());
//                            currentNeighbour.setPath(new ArrayList<>(current.getPath()));
//                        }
//                        unvisited.add(currentNeighbour);
//                        break;
//                    }
//                }
//            }
//
//            Graph.ShortestPath shortestPath = new Graph.ShortestPath(source, current.name, current.distance, current.path);
//            visited.put(current.getName(), shortestPath);
//            current = unvisited.poll();
//
//        }
//        return visited;
//
//    }