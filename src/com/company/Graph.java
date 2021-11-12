package com.company;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Graph {
    private  ArrayList<Station> stations;
    ArrayList<ArrayList<Double>> lengths;
    private static final double MAXLENGTH = Double.MAX_VALUE;

    public  void addStation(Station station){
        stations.add(station);
        lengths.add(new ArrayList<Double>());
    }

    public void addLength(Station station,Station secondStation,double length) throws NoSuchStationException {
        if(stations.contains(station) && stations.contains(secondStation)){
            int index = stations.indexOf(station);
            int secondIndex = stations.indexOf(secondStation);
            lengths.get(index).set(secondIndex,length);// spisok rasstoyaniy ot stanciy index do vsex drugix
            lengths.get(secondIndex).set(index,length);
        } else {
            throw new NoSuchStationException();
        }
    }
    

}

// TODO: 05.11.2021 NoSuchStation Exception, menu addStation(reshit problemu s nulevymi rasstoyaniyami),method kotoryy naxodit rasstoyaniya
// TODO: 05.11.2021 deixtra,  