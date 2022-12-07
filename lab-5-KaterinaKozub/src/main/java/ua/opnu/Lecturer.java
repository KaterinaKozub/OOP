package ua.opnu;

public class Lecturer extends Person {
    private String depart;
    private float salary;

    public Lecturer(String surname, String name, int age, String depart, float salary) {
        super(surname, name, age);
        this.depart = depart;
        this.salary = salary;

        if (salary <= 0)
            this.salary = 0;
    }

    public String getDepart() {
        return depart;
    }

    public float getSalary() {
        return salary;
    }

    public String toString() {
        return "Викладач кафедри " + getDepart() + ", " + super.toString() +
                ". Зарплата: " + getSalary();
    }
}
