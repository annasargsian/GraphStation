package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph{
    private static String[] allStation;
    private static String firstStation;
    ArrayList<ArrayList<Vertex>> arrayList = new ArrayList<>();

    public static void addStation(String station){
        if(allStation.length == 0){
            firstStation = station;

        }
    }
    public static void askQuestion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add station that you want to add");
        String station = scanner.next();
        if(station != " "){
            addStation(station);
            System.out.println("Please fill connection that have station or if it is last just leave fill empty ");
            String connection = scanner.next();
            ArrayList<String> nearStation = new ArrayList<>();
            while (scanner.hasNext(connection)){
                nearStation.add(connection);
                scanner.next();
            }
            addVertex(station,nearStation);

        } else {
            System.out.println("empty field");
        }
    }

    public static void addVertex(String station,ArrayList<String> nearStation){

    }
    private class Vertex{
        String station;
        String[] nearStations;
    }
}
