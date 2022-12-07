package ua.opnu;

public class Main {
    public static void main(String[] args) {
            Student s1 = new Student("Настя", 3);
            s1.addCourse("ООП");
            s1.addCourse("Вища математика");
            s1.addCourse("Фізична культура");
            s1.print();
            System.out.println(s1. courseDisciplines);
            System.out.println(s1.getCourseCount());
            System.out.println(s1. getName());
            System.out.println(s1. getTuition());
            System.out.println(s1. getYear());

        }
    }


