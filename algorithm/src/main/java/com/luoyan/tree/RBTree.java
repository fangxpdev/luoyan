package com.luoyan.tree;

public class RBTree<E> extends BST<E> {

    public static final boolean RED = true;
    public static final boolean BLACK = false;

    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;
        //1.添加的根节点  黑化节点返回
        if (parent == null) {

        }

        //2. 如何父节点的颜色是黑色， 不需要处理，直接返回

        //3. 叔父节点是红色 上溢
        // black(parent) black(uncle)

    }

    @Override
    protected void afterRemove(Node<E> node) {
        super.afterRemove(node);
    }


    private Node<E> color(Node<E> node, boolean color) {
        if (node == null) {
            return node;
        }
        ((RBNode<E>) node).color = color;
        return node;
    }


    private class RBNode<E> extends Node<E> {

        boolean color = RED;

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }
    }

}
