package DesignGuru.practice;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedAlgo {

    private class Node {
        int key;
        int value;
        Node previous;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;

    private Node left;
    private Node right;

    LeastRecentlyUsedAlgo(int capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.previous = this.left;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).value;
        } else {
            return -1;
        }
    }
    public void remove(Node node){
        Node prev = node.previous;
        Node next = node.next;

        prev.next = next;
        next.previous = prev;

    }
    public void insert(Node node) {
        Node prev = this.right.previous;
        Node next = this.right;

        prev.next = node;
        next.previous = node;

        node.next = next;
        node.previous = prev;
    }

    public void insert(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if(cache.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
