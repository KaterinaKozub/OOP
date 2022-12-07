package src;

public class GenericTest<T, V, S> {
    public static void main(String[] args) {
        GenericTwoTuple<Integer, String> TwoTuple1 = new GenericTwoTuple<>(1, "Masha");
        GenericTwoTuple<Integer, String> TwoTuple2 = new GenericTwoTuple<>(2, "Alla");
        GenericTwoTuple<Integer, String> TwoTuple3 = new GenericTwoTuple<>(3, "Ivan");
        GenericThreeTuple<String, String, String> ThreeTuple1 = new GenericThreeTuple<>("Микола", "Олегович", "Кондратюк");
        GenericThreeTuple<Integer, String, Double> ThreeTuple2 = new GenericThreeTuple<>(5, "Artem", 3.50);
        GenericThreeTuple<String, String, Integer> ThreeTuple3 = new GenericThreeTuple<>("Катерина", "Романівна", 18);

        System.out.println("--------- " + TwoTuple1.getClass().getSimpleName() + "--------- " + "\n");

        System.out.println( TwoTuple1.toString() + "\n");

        System.out.println( TwoTuple2.toString() + "\n");

        System.out.println(TwoTuple2.toString() + "\n");

        System.out.println("--------- " + ThreeTuple1.getClass().getSimpleName() + "--------- " + "\n");

        System.out.println( ThreeTuple1.toString() + "\n");

        System.out.println (ThreeTuple1.toString() + "\n");

        System.out.println(ThreeTuple3.toString() + "\n");


    }
}

