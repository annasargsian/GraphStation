package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Application {
    Graph graph = new Graph();

    public void menu() throws NoSuchStationException {
        Scanner canner = new Scanner(System.in);
        do{
        System.out.println("1. Add station");
        System.out.println("2. Add a roads length between stations");
        System.out.println("3. Calculate the shortest path between stations");
        System.out.println("4. Exit");

        Scanner scanner = new Scanner(System.in);
        canner = scanner;
        int button = scanner.nextInt();
        if (button == 1) {
            System.out.println("Please add station");
            String stationName = scanner.next();
            Graph.Station station = new Graph.Station(stationName);
            graph.addStation(station);
        } else if (button == 2) {
            System.out.println("Please add first station");
            String firstName = scanner.next();
            Graph.Station firstStation = new Graph.Station(firstName);
            System.out.println("Please add second station");
            String secondName = scanner.next();
            Graph.Station secondStation = new Graph.Station(secondName);
            System.out.println("Please add length between stations");
            int length = scanner.nextInt();
            graph.addLength(firstStation, secondStation, length);
        } else if (button == 3) {
            System.out.println("Please add starting station");
            String firstStation = scanner.next();
            System.out.println("Please add end station");
            String secondStation = scanner.next();
//            Graph.dijkstra(Graph.stations.get(Graph.stations.indexOf(firstStation)), Graph.stations.get(Graph.stations.indexOf(secondStation)));
            graph.shortPath(firstStation,secondStation);

        } else if (button == 4) {
            System.exit(0);
        }
    }while(!canner.equals(4));
    }
}


