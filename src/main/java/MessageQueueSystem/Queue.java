package MessageQueueSystem;

public class Queue {
    private final int MAX_MESSAGE_LENGTH = 250;
    private String[] queue;
    private int front;
    private int rear;
    private int size;

    public Queue() {
        this.queue = new String[MAX_MESSAGE_LENGTH];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(String item) {
        if (item.length() > MAX_MESSAGE_LENGTH) {
            throw new IllegalArgumentException("Message length should not exceed 250 characters.");
        }
        if (size == MAX_MESSAGE_LENGTH) {
            throw new IllegalStateException("Queue is full. Cannot enqueue.");
        }
        rear = (rear + 1) % MAX_MESSAGE_LENGTH;
        queue[rear] = item;
        size++;
    }

    public String dequeue() {
        if (is_empty()) {
            throw new IllegalStateException("Queue is empty. Cannot dequeue.");
        }
        String item = queue[front];
        front = (front + 1) % MAX_MESSAGE_LENGTH;
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
