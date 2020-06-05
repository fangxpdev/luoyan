package com.luoyan.tree;

import java.util.Comparator;

/**
 * 二叉搜索树
 *
 * @author michael
 */
public class BST<E> extends BinaryTree<E> {

    private Comparator<E> comparator;

    public BST() {
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void add(E element) {
        //添加第一个节点
        if (root == null) {
            root = createNode(element, null);
            size++;
            //调整平衡 子类实现
            afterAdd(root);
            return;
        }

        Node<E> node = this.root;
        Node<E> parent = this.root;
        int cmp = 0;
        while (node != null) {
            parent = node;
            cmp = compare(element, node.element);
            if (cmp > 0) {
                //右边
                node = node.right;
            } else if (cmp < 0) {
                //左边
                node = node.left;
            } else {
                //覆盖
                node.element = element;
                return;
            }
        }
        Node<E> newNode = createNode(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        //调整平衡 子类实现
        afterAdd(newNode);
    }

    /**
     * 添加node之后的调整
     */
    protected void afterAdd(Node<E> node) {
    }

    /**
     * 删除node之后的调整
     */
    protected void afterRemove(Node<E> node) {
    }

    public void remove(E element) {
        remove(node(element));
    }

    private void remove(Node<E> node) {
        if (node == null) {
            return;
        }
        //度为2的节点
        if (node.hasTwoChildren()) {
            Node<E> successor = successor(node);
            //覆盖值
            node.element = successor.element;
            //将要删除的节点
            node = successor;
        }

        Node<E> replacement = node.left != null ? node.left : node.right;

        //度为1的节点删除
        if (replacement != null) {
            replacement.parent = node.parent;
            if (node.parent == null) {
                //root节点
                root = replacement;
            } else if (node == node.parent.left) {
                //node为原父节点的左节点
                node.parent.left = replacement;
            } else if (node == node.parent.right) {
                node.parent.right = replacement;
            }

        } else {
            //度为0 叶子节点
            if (node.parent == null) {
                //根节点
                root = null;
            } else {
                if (node.parent.left == node) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
            }
        }
    }

    private Node<E> node(E element) {
        if (root == null) {
            return null;
        }
        Node<E> node = root;
        while (node != null) {

            int cmp = compare(element, node.element);
            if (cmp == 0) {
                return node;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }


    boolean contain(E element) {
        return false;
    }


    /**
     * 比较器
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }


}
