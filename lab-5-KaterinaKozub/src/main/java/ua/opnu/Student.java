package ua.opnu;

public class Student extends Person {
    private String group;
    private int id;

    public Student(String surname, String name, int age, String group, int id) {
        super(surname, name, age);
        this.group = group;
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Студент групи " + getGroup() + ", " + super.toString() +
                ". Номер студентського квитка: " + getId();
    }
}