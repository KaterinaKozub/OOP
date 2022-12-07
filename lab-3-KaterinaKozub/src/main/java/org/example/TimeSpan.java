package org.example;

public class TimeSpan {
    int hours;
    int minutes;

    TimeSpan(int hours, int minutes) {
        if (isValidTime(hours, minutes)) {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    double getTotalHours() {
        double value = (double) minutes / 60;
        return hours + value;
    }

    int getTotalMinutes() {
        int value = hours * 60;
        return value + minutes;
    }

    void add(int hours, int minutes) {
        if (isValidTime(hours, minutes)) {
            this.hours = this.hours + hours;
            this.minutes = this.minutes + minutes;
            convertTimeCorrectly();
        }
    }

    void addTimeSpan(TimeSpan span) {
        hours = hours + span.getHours();
        minutes = minutes + span.getMinutes();
        convertTimeCorrectly();
    }

    void subtract(TimeSpan span) throws IllegalArgumentException {
        int subtractMinutes = span.getMinutes();
        int subtractHours = span.getHours();

        if (getTotalMinutes() >= span.getTotalMinutes()){
            hours = hours - subtractHours;
            minutes = minutes - subtractMinutes;
        } else {
            throw new IllegalArgumentException();
        }
    }

    void scale(int factor) {
        if (factor >= 0){
            hours = hours * factor;
            minutes = minutes * factor;
            convertTimeCorrectly();
        }

    }

    private boolean isValidTime(int hours, int minutes) {
        return minutes >= 0 && minutes < 60 && hours >= 0;
    }

    private void convertTimeCorrectly() {
        hours = hours + minutes / 60;
        minutes = minutes % 60;
    }

}

