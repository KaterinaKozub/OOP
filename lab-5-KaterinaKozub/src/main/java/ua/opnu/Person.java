package ua.opnu;

public class Person {
    private String surname;
    private String name;
    private int age;

    public Person(String surname, String name, int age) {
        if (age <= 0 || age > 120)
            return;
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return getSurname() + " " + getName() + ", вік: " + getAge();
    }
}
