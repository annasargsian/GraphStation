package com.company;

import java.util.*;

public class NoSuchStationException extends Throwable {
    public NoSuchStationException() {
        System.out.println("There is no such station");
    }
}
