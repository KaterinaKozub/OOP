package src;

public class Contains <T extends Comparable<T>> {
    <V extends T> boolean contains(T[] array, V element) {

        for (T str : array)
            if (str.equals(element))
                return true;

        return false;
    }
}
