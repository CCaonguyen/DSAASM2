package MessageQueueSystem;

public class Stack {
    private final int MAX_MESSAGE_LENGTH = 250;
    private String[] stack;
    private int top;
    private int size;

    public Stack() {
        this.stack = new String[MAX_MESSAGE_LENGTH];
        this.top = -1;
        this.size = 0;
    }

    public void push(String item) {
        if (item.length() > MAX_MESSAGE_LENGTH) {
            throw new IllegalArgumentException("Message length should not exceed 250 characters.");
        }
        if (size == MAX_MESSAGE_LENGTH) {
            throw new IllegalStateException("Stack is full. Cannot push.");
        }
        top++;
        stack[top] = item;
        size++;
    }

    public String pop() {
        if (is_empty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        String item = stack[top];
        top--;
        size--;
        return item;
    }

    public boolean is_empty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
