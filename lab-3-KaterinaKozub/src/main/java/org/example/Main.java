package org.example;

public class Main {
    public static void main(String[] args) {
        int hr;
        int min;
        int sec;
        int[] temp;
        Time currTime = new Time();
        currTime.setTime(23, 59, 59);
        temp = currTime.getTime();
        hr = temp[0];
        min = temp[1];
        sec = temp[2];
        System.out.println(
                "Поточний встановлений час: "
                        + hr + ":" + min + ":" + sec
        );
        currTime.incrementTime();
        temp = currTime.getTime();
        hr = temp[0];
        min = temp[1];
        sec = temp[2];
        System.out.println(
                "Після інкременту часу, поточний час: "
                        + hr + ":" + min + ":" + sec
        );
        currTime.hour = 31;
        currTime.minute = -10;
        currTime.second = 450;
        temp = currTime.getTime();
        hr = temp[0];
        min = temp[1];
        sec = temp[2];
        System.out.println(
                "After direct assignment, the current military time is:"
                        + hr + ":" + min + ":" + sec
        );
        temp = currTime.getTime();
        hr = temp[0];
        min = temp[1];
        sec = temp[2];
        System.out.println(
                "The initial military time is set to: "
                        + hr + ":" + min + ":" + sec
        );
    }
}