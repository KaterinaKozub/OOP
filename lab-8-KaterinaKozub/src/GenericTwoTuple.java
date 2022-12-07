package src;

public class GenericTwoTuple <T , V>{

    public final T first;
    public final V second;

    public GenericTwoTuple(T first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ')';
    }
}

