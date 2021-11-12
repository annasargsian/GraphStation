package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {
    Graph graph = new Graph();
        public  void menu(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please add station that you want to add");
            String station =  scanner.next();
            if(station != " "){
                Station station1 = new Station(station);
                graph.addStation(station1);
                System.out.println("Please fill connection that have station or if it is last just leave fill empty ");
                String connection = scanner.next();
                ArrayList<String> nearStation = new ArrayList<>();
                while (scanner.hasNext(connection)){
                    nearStation.add(connection);
                    scanner.next();
                }


            } else {
                System.out.println("empty field");
            }
        }
    }

