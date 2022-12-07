package ua.opnu;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        //1
        Predicate p = primeNumber -> {
            if((int)primeNumber == 2 || (int)primeNumber < 0)
                return false;
            for(int i = 2; i <= (int)primeNumber/2; i++){
                int value = (int)primeNumber % i;
                if(value == 0){
                    return false;
                }
            }
            return true;
        };

        //2
        Student student1 = new Student("Катерина", "AI-212", new int[]{90, 90, 85, 90, 90});
        Student student2 = new Student("Элла", "AI-212", new int[]{100, 80, 76, 100, 65});
        Student student3 = new Student("Настя", "AI-212", new int[]{92, 75, 65, 67, 45});

        Student[] students = new Student[]{student1, student2, student3};

        Predicate goodMarks = stud -> {

            Student student = (Student)stud;
            for(int i = 0; i<student.getMarks().length; i++){
                if(student.getMarks()[i] < 60){
                    return false;
                }
            }
            return true;
        };

        Student[] result = Student.filter(students, goodMarks);
        System.out.println(Arrays.toString(result));

        //3
        Predicate belongToGroup = stud -> {

            Student student = (Student)stud;
            if(student.getGroup() != "AI-212")
                return false;
            return true;
        };

        Student[] result2 = Student.filter(students, goodMarks, belongToGroup);
        System.out.println(Arrays.toString(result2));


        //4
        Consumer studentInfo = (stud) -> {

            Student student = (Student)stud;

            System.out.println(student.getName() + " " + student.getGroup());

        };

        forEach(students, studentInfo);


        //5
        int[] array = new int[]{10, 20, 3, 5, 30};

        Predicate arr = a -> (int)a % 10 == 0;

        Consumer returnArr = (a) -> System.out.println(a);

        ifPredicate(array, arr, returnArr);

        //6
        int[] array2 = new int[]{5, 2, 6, 9, 4, 7, 1, 6, 10, 3};

        Function degree = f -> {

            int value = (int)f;
            return value * value;

        };

        int[] resultArray2 = function(array2, degree);
        System.out.println(Arrays.toString(resultArray2));

        //7
        int[] array3 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Function arrayToString = f -> {

            int value = (int)f;
            String text;

            switch(value){
                case 0 -> text = "нуль";
                case 1 -> text = "один";
                case 2 -> text = "два";
                case 3 -> text = "три";
                case 4 -> text = "чотири";
                case 5 -> text = "п'ять";
                case 6 -> text = "шість";
                case 7 -> text = "сім";
                case 8 -> text = "вісім";
                case 9 -> text = "дев'ять";
                default -> text = "Error";
            }

            return text;

        };

        stringify(array3, arrayToString);

    }


    public static void forEach(Student[] input, Consumer action) {
        for (Student i : input) {
            action.accept(i);
        }
    }


    public static void ifPredicate(int[] input, Predicate p, Consumer c){

        for(int i : input)
            if(p.test(i)){
                c.accept(i);
            }

    }

    public static int[] function(int[] array, Function f){

        int[] result = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            result[i] = (int) f.apply(array[i]);
        }

        return result;
    }

    public static void stringify(int[] array, Function f){

        for(int i : array){
            System.out.println(f.apply(array[i]));
        }
    }

}