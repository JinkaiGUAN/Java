/**
 * @author: Peter
 * @date: 31/12/2021
 * @description:
 */
public class QueueByLinkedList {
    public static class QueueNode {
        int val;
        QueueNode next;

        public QueueNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    QueueNode front, rear;

    public QueueByLinkedList() {

    }

    public void enqueue(int val) {
        QueueNode newNode = new QueueNode(val);

        if (front == null) {
             front = rear = newNode;
             return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (front == null) {
            System.out.println("The queue is empty.");
            return Integer.MIN_VALUE;
        }
        QueueNode frontNode = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return frontNode.val;
    }

}
