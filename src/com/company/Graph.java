package com.company;

import java.util.*;

public class Graph {
    public static ArrayList<Station> stations = new ArrayList<>(10);
    private static ArrayList<ArrayList<Double>> lengths = new ArrayList<>(10);
    private static final double MAXLENGTH = Double.MAX_VALUE;

    public void addStation(Station station) {
        stations.add(station);
        int index = stations.indexOf(station);
        System.out.println(index);
        System.out.println(stations.get(index).getName());
        lengths.add(index, new ArrayList<Double>());
    }

    public void addLength(Station station, Station secondStation, double length) throws NoSuchStationException {
        if (stations.contains(station) && stations.contains(secondStation)) {
            int index = stations.indexOf(station);
            int secondIndex = stations.indexOf(secondStation);
            if (lengths.get(index).contains(secondIndex) && lengths.get(secondIndex).contains(index)) {
                lengths.get(index).set(secondIndex, length);
                lengths.get(secondIndex).set(index, length);
            } else if (lengths.get(index).contains(secondIndex) && !lengths.get(secondIndex).contains(index)) {
                lengths.get(index).set(secondIndex, length);
                lengths.get(secondIndex).add(index, length);
            }  else if (!lengths.get(index).contains(secondIndex) && lengths.get(secondIndex).contains(index)) {
                lengths.get(index).add(secondIndex, length);
                lengths.get(secondIndex).set(index, length);
            } else {
                lengths.get(index).add(secondIndex, length);
                lengths.get(secondIndex).add(index, length);
            }
        } else {
            throw new NoSuchStationException();
        }
    }

    public static void dijkstra(Station station, Station secondStation) {

    }


}
