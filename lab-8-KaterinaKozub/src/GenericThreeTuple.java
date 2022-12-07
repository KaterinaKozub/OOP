package src;

public class GenericThreeTuple <T, V,S> {

    public final T first;
    public final V second;
    public  final S three;

    public GenericThreeTuple(T first, V second, S three) {
        this.first = first;
        this.second = second;
        this.three = three;
    }



    @Override
    public String toString() {
        return "(" + first + "," + second + "," + three + ")";
    }
}
