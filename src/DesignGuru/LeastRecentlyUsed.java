package DesignGuru;


import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsed {

    private class Node {
        int key;
        int val;
        Node previous;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;

    private Node left;
    private Node right;

    public LeastRecentlyUsed(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();

        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.previous = this.left;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }

        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if(cache.size() > capacity){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    public void remove(Node node) {
        Node prev = node.previous;
        Node next = node.next;

        prev.next = next;
        next.previous = prev;
    }

//    insert node at right
    public void insert(Node node) {
        Node prev = this.right.previous;
        Node next = this.right;

        prev.next = node;
        next.previous = node;

        node.next = next;
        node.previous = prev;
    }
}
