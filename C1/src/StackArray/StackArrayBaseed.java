package StackArray;

public class StackArrayBaseed {
    private final int MAX_Stack = 100;

    private int top;

    private Object[] items;

    public StackArrayBaseed() {
        items = new Object[MAX_Stack];
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == MAX_Stack - 1;
    }

    public void push(Object item) {
        if (!isFull()) {
            
        }
    }
}
