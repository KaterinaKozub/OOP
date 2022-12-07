package ua.opnu;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Козуб", "Катерина", 18, "АІ-212", 3421342);
        Student student2 = new Student("Сочесло", "Олександер", 18, "АІ-212", 7654321);
        Student student3 = new Student("Червинкова", "Даниела", 18, "АІ-212", 9956345);

        Lecturer lecturer1 = new Lecturer("Годовиченко", "Микола", 30,
                "Інформаційні технології", 32000);
        Lecturer lecturer2 = new Lecturer("Глава", "Марія", 40,
                "Інформаційні технології", 32000);
        Lecturer lecturer3 = new Lecturer("Маникаева", "Ольга", 35,
                "Інформаційні технології", 32000);

        Person[] person = {student1, student2, student3, lecturer1, lecturer2, lecturer3};

        for (Person value : person) {
            System.out.println(value);
        }
    }
}