package com.luoyan.tree;

import java.util.Comparator;

public class AVLTree<E> extends BST<E> {

    public AVLTree() {
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) {

        }
    }

    @Override
    protected void afterRemove(Node<E> node) {

    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }

    private class AVLNode<E> extends Node<E> {

        int height = 1;

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            return 0;
        }
    }

}
