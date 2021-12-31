/**
 * @author: Peter
 * @date: 31/12/2021
 * @description:
 */
public class QueueByArray {
    int front, rear, size;
    int capacity;
    int[] array;

    public QueueByArray(int capacity) {
        this.capacity = capacity;
        this.front = this.rear = this.size = 0;
        this.array = new int[this.capacity];
    }

    public void enqueue(int val) {
        if (isFull()) return;

        array[rear] = val;
        rear = (++size) % capacity;
        System.out.println(val + " is enqueued.");
    }

    public int dequeue() {
        if (isEmpty()) return Integer.MIN_VALUE;

        int item = array[front];
        front = (front + 1) % capacity;
        size--;

        return item;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }


}
