import java.util.HashMap;
import java.util.Map;

/**
 * @author: Peter
 * @date: 30/12/2021
 * @description: https://leetcode-cn.com/problems/lru-cache/
 */

/**
 * 在此结构中， 我们定义最近使用会被移动到head， 最后从tail逐出。
 */
public class LRUCache {
    public static class ListNode {
        int key; // 存储当前node的key， 便于在delete的时候找到cache的key
        int val;
        ListNode next;
        ListNode prev;

        ListNode () {}

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private int size;
    private ListNode head, tail; // Double LinkedList dummy head and tail.
    private Map<Integer, ListNode> cache = new HashMap<Integer, ListNode>();

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        // initialize the double linkedlist
        this.head = new ListNode();
        this.tail = new ListNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void add2Head(ListNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void move2Head(ListNode node) {
        deleteNode(node);
        add2Head(node);
    }

    public void deleteNode(ListNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public ListNode removeTail() {
        ListNode temp = tail.prev;
        deleteNode(temp);
        return temp;
    }

    public int get(int key) {
        ListNode node = cache.get(key);

        if (node == null) return -1;

        // move the node to the head.
        move2Head(node);

        return node.val;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node == null) {
            // cache 中没有记录
            node = new ListNode(key, value);
            cache.put(key, node);
            add2Head(node);
            ++size;

            if (size > capacity) {
                ListNode removedNode = removeTail();
                cache.remove(removedNode.key);
                --size;
            }
        }
        node.val = value;
        move2Head(node);
    }
}
