package src;

public class StackString implements Stack<String> {
    private String[] array;
    private int top;
    private int capacity;

    public StackString(int size) {
        array = new String[size];
        capacity = size;
        top = -1;
    }

    @Override
    public void push(String element) {
        if (isFull()) {
            System.out.println("Program Terminated\n");
            System.exit(-1);
        }

        System.out.println("Inserting " + element);
        array[++top] = element;
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            System.out.println("Program Terminated\n");
            System.exit(-1);
        }

        System.out.println("Removing " + peek());
        return array[top--];
    }

    @Override
    public String peek() {
        if (!isEmpty()) {
            return array[top];
        }
        else {
            System.exit(-1);
        }
        return "Error";
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void clear() {
        for(int i = 0; i < capacity - 1; i++){
            array[i] = null;
        }
    }

    public boolean isFull(){
        return top == capacity - 1;
    }

    public int size(){
        return top + 1;
    }
}


