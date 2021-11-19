package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Application {
    Graph graph = new Graph();
    Random RANDOM = new Random();

    public void menu() {
        System.out.println("1. Add station");
        System.out.println("2. Add a roads length between stations");
        System.out.println("3. Calculate the shortest path between stations");
        System.out.println("4. Exit");
        ;
        Scanner scanner = new Scanner(System.in);
        int button = scanner.nextInt();
        if (button == 1) {
            System.out.println("Please add station");
            String stationName = scanner.next();
            Station station = new Station(stationName, RANDOM);
            graph.addStation(station);
        } else if (button == 2) {
            System.out.println("Please add first station");
            String firstName = scanner.next();
            Station firstStation = new Station(firstName, RANDOM);
            System.out.println("Please add second station");
            String secondName = scanner.next();
            Station secondStation = new Station(secondName, RANDOM);
            System.out.println("Please add length between stations");
            double length = scanner.nextDouble();
            try {
                graph.addLength(firstStation, secondStation, length);
            } catch (NoSuchStationException e) {
                e.printStackTrace();
            }
        } else if (button == 3) {
            System.out.println("Please add starting station");
            String firstStation = scanner.next();
            System.out.println("Please add end station");
            String secondStation = scanner.next();
            Graph.dijkstra(Graph.stations.get(Graph.stations.indexOf(firstStation)), Graph.stations.get(Graph.stations.indexOf(secondStation)));

        } else if (button == 4) {
            System.exit(0);
        }
    }
}


