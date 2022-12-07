package src;

interface Stack<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
    void clear();
}

