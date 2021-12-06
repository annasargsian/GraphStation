package com.company;

import java.util.Scanner;

public class Application {
    NavigationMap navigationMap = new NavigationMap();

    public void menu() throws NoSuchStationException {
        Scanner canner;
        do {
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
                Station station = new Station(stationName);
                navigationMap.addStation(station);
            } else if (button == 2) {
                System.out.println("Please add first station");
                String firstName = scanner.next();
                Station firstStation = new Station(firstName);
                System.out.println("Please add second station");
                String secondName = scanner.next();
                Station secondStation = new Station(secondName);
                System.out.println("Please add length between stations");
                int length = scanner.nextInt();
                navigationMap.addLength(firstStation, secondStation, length);
            } else if (button == 3) {
                System.out.println("Please add starting station");
                String firstStation = scanner.next();
                if(!NavigationMap.map.containsKey(firstStation)){
                       throw new NoSuchStationException();
                }
                System.out.println("Please add end station");
                String secondStation = scanner.next();
                if(!NavigationMap.map.containsKey(secondStation)){
                    throw new NoSuchStationException();
                }
                navigationMap.shortPath(firstStation, secondStation);

            } else if (button == 4) {
                System.exit(0);
            }
        } while (!canner.equals(4));
    }
}


