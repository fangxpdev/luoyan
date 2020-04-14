package com.luoyan.linkedlist;


public class MyPriorityLinkedList<E extends Comparable> {

    private Node<E> first;

    private int size;

    public boolean isEmpty() {

        return size == 0;

    }

    public static <E extends Comparable> MyPriorityLinkedList<E> of(E... elements) {
        MyPriorityLinkedList list = new MyPriorityLinkedList();
        if (elements.length > 0) {
            for (E element : elements) {
                list.addFirst(element);
            }
        }

        return list;

    }

    public MyPriorityLinkedList<E> addFirst(E value) {

        Node<E> newNode = new Node<>(value);
        Node<E> currentNode = first;
        Node<E> preNode = null;
        while (currentNode != null && value.compareTo(currentNode.value) > 0) {
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        if (preNode == null) {
            first = newNode;
        } else {
            preNode.next = newNode;
        }
        newNode.next = currentNode;
        size++;
        return this;
    }

    public MyPriorityLinkedList<E> addLast(E value) {

        Node<E> newNode = new Node<>(value);
        Node<E> currentNode = first;
        if (first == null) {
            first = newNode;
        } else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            size++;
        }
        return this;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E res = first.value;
        this.first = first.next;
        size--;
        return res;
    }

    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> currentNode = first;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        E res = (E) currentNode.next.value;
        currentNode.next = null;
        size--;
        return res;
    }

    public boolean contains(E element) {
        Node<E> currentNode = first;
        while (currentNode != null) {
            if (currentNode.value == element) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            Node<E> currentNode = first;
            builder.append("[");
            while (currentNode != null) {
                builder.append(currentNode.value);
                builder.append(",");
                currentNode = currentNode.next;
            }
            builder.replace(builder.length() - 1, builder.length(), "]");
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        MyPriorityLinkedList<Integer> list = MyPriorityLinkedList.of(1, 3, -1, 0, 10, 7, 6);
        list.addFirst(1);
        System.out.println(list.toString());
    }


    static class Node<E> {

        E value;

        Node next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
