/**
 * @author: Peter
 * @date: 29/12/2021
 * @description: https://leetcode.com/problems/design-linked-list/submissions/
 */
public class DesignLinkedList {

    /**
     * 构造双链表节点。
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;  // dummy head
    ListNode tail; // dummy tail
    int size;

    public DesignLinkedList() {
        // 初始化头尾节点；
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        this.head.next = this.tail;
        this.tail.prev = this.head;

        this.size = 0;
    }

    public int get(int index) {
        if (index >= size) return -1;

        int i = 0;
        ListNode cur = head.next;
        while (i < index) {
            cur = cur.next;
            i++;
        }

        return cur.val;

    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);

        newNode.next = head.next;
        head.next.prev = newNode;
        newNode.prev = head;
        head.next = newNode;

        size += 1;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);

        tail.prev.next = newNode;
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev = newNode;

        size += 1;
    }

    public void deleteAtIndex(int index) {
        if (index < size) {
            int i = 0;
            ListNode cur = head.next;
            while (i < index) {
                cur = cur.next;
                i++;
            }

            // delete the node
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;

            size--;

        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list.
     * <p>
     * If index equals the length of the linked list, the node will be appended to the end of the linked list. If
     * index is greater than the length, the node will not be inserted.
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index <= size) {
            ListNode newNode = new ListNode(val);

            int i = 0;
            ListNode cur = head.next;
            while (i < index) {
                cur = cur.next;
                i++;
            }

            // Insert the node.
            newNode.next = cur;
            cur.prev.next = newNode;
            newNode.prev = cur.prev;
            cur.prev = newNode;

            size++;
        }
    }

    public void displayInfo() {
        if (size >= 0) {
            ListNode cur = head.next;
            for (int i = 0; i < size; i++) {
                System.out.print(cur.val + " -> ");
                cur = cur.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DesignLinkedList doubleLinkedList = new DesignLinkedList();

        //["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail",
        // "get","addAtHead","addAtIndex","addAtHead"]
        //[[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
        doubleLinkedList.addAtHead(7);
        doubleLinkedList.addAtHead(2);
        doubleLinkedList.addAtHead(1);
        doubleLinkedList.addAtIndex(3, 0);
        doubleLinkedList.displayInfo();
        doubleLinkedList.deleteAtIndex(2);
        doubleLinkedList.displayInfo();

        doubleLinkedList.addAtHead(6);
        doubleLinkedList.addAtTail(4);
        doubleLinkedList.displayInfo();

        System.out.println(doubleLinkedList.get(4));
        doubleLinkedList.addAtHead(4);
        doubleLinkedList.addAtIndex(5, 0);
        doubleLinkedList.addAtHead(6);

    }
}
