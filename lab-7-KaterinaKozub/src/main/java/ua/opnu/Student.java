package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

class Student {
    private String name;
    private String group;
    private int[] marks;

    public Student(String name, String group, int[] marks) {
        this.name = name;
        this.group = group;
        this.marks = marks;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public static Student[] filter(Student[] input, Predicate p) {

        Student[] result = new Student[input.length];

        int count = 0;
        for (Student i : input) {
            if (p.test(i)) {
                result[count] = i;
                count++;
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }

    @Override
    public String toString() {
        return "Student " + this.name + ". Group " + this.group + ". Marks: " + Arrays.toString(marks);
    }

    public static Student[] filter(Student[] input, Predicate p1, Predicate p2) {

        Student[] result = new Student[input.length];

        int count = 0;
        for (Student i : input) {
            if (p1.test(i) && p2.test(i)) {
                result[count] = i;
                count++;
            }
        }
        return Arrays.copyOfRange(result, 0, count);

    }
}
