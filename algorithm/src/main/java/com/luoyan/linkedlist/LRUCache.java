package com.luoyan.linkedlist;


import java.util.HashMap;

public class LRUCache {

    private int capacity;

    private DoubleList cache;

    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.cache = new DoubleList();
        this.map = new HashMap<>();

    }


    int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }

        Node x = map.get(key);

        put(x.key, x.val);

        return x.val;
    }

    void put(int key, int value) {

        Node x = new Node(key, value);

        if (map.containsKey(x.key)) {

            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);

        } else {
            if (cache.size() == capacity) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            map.put(key, x);
            cache.addFirst(x);
        }

    }


    class DoubleList {

        private Node head, tail;

        private int size;

        public DoubleList() {

            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;
            size++;
        }

        public void remove(Node x) {

            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;

        }


        public Node removeLast() {

            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int size() {
            return size;
        }
    }

    class Node {

        private int key, val;

        private Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }


    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        System.out.println(lruCache.get(1));


        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));

        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));


    }

}
