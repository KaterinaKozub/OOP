package ua.opnu;

import java.util.ArrayList;
import  java.util.ArrayList;
public class Student {
    String name;
    int year;
    public ArrayList<String> courseDisciplines = new ArrayList<>();


    Student(String name, int year){
        if(year >= 1 && year <= 4)
            this.name = name;
        this.year = year;
    }
    public void addCourse(String courseName) {
        courseDisciplines.add(courseName);
    }
    public int getCourseCount() {
        return courseDisciplines.size();
    }
    public  String getName(){
        return this.name;
    }
    public int getTuition(){
        return this.year*20000;
    }
    public int getYear(){
        return this.year;
    }
    public void print(){

        System.out.println("Имя: "+ name+",\nГод обучения: "+ year);
    }

}
