package com.luoyan.tree;

import com.luoyan.tree.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> implements BinaryTreeInfo {

    protected int size;

    protected Node<E> root;

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void clear() {
        root = null;
        size = 0;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<E> node) {

        if (node == null) {
            return;
        }
        System.out.println(node.element);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.element);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.element);
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node<E> node) {
        if (node == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node<E> n = queue.poll();
            System.out.println(n.element);
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
        }
    }

    public int height() {
        return height(root);
    }


    public interface Visitor<E> {
        void visit(E element);
    }

    /**
     * 可自定义数据访问逻辑
     *
     * @param visitor
     */
    public void levelOrder(Visitor<E> visitor) {
        if (root == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node<E> n = queue.poll();
            visitor.visit(n.element);
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
        }
    }

    public int height(Node<E> node) {
        if (node == null) {
            return 0;
        }

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        int height = 0;
        int levelSize = 1;

        while (!queue.isEmpty()) {
            Node<E> n = queue.poll();
            levelSize--;
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                height++;
            }
        }
        return height;

    }

    public boolean isComplete() {
        if (root == null) {
            return false;
        }

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        boolean isLeaf = false;

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (isLeaf && !node.isLeaf()) {
                return false;
            }

            //两个叶子节点正常入队
            if (node.hasTwoChildren()) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) {
                //没有左子树 有右子树 false
                return false;
            } else {
                // left == null  && right == null
                // left != null  && right == null
                if (node.left != null) {
                    queue.offer(node);
                }
                isLeaf = true;
            }
        }
        return true;
    }

    public boolean isComplete2() {
        if (root == null) {
            return false;
        }

        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        boolean isLeaf = false;

        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (isLeaf && !node.isLeaf()) {
                return false;
            }

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                // left == null && right != null
                return false;
            }

            if (node.right != null) {
                queue.offer(node.right);
            } else {
                //left != null && right == null
                //left == null && right == null
                isLeaf = true;
            }
        }
        return true;
    }

    /**
     * 前驱节点
     *
     * @param node
     * @return
     */
    protected Node<E> predecessor(Node<E> node) {
        if (node == null) {
            return null;
        }
        Node<E> p = node.left;
        //前驱节点在左子树中  （node.left.right.right...）
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        //前驱节点在父节点  一旦节点为右节点 为前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }

        //node.parent = null
        //node.parent.right = node
        return node.parent;
    }


    protected Node<E> successor(Node<E> node) {

        if (node == null) {
            return null;
        }
        Node<E> p = node.right;
        //前驱节点在右子树中  （node.right.left.left...）
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        //前驱节点在父节点  一旦节点为左节点 为前驱节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        //node.parent = null
        //node.parent.left = node
        return node.parent;

    }

    protected Node<E> createNode(E element, Node<E> parent) {
        return new Node<>(element, parent);
    }

    protected static class Node<E> {
        E element;

        Node<E> left;

        Node<E> right;

        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }

        public Node<E> sibling() {
            if (isLeftChild()) {
                return parent.right;
            }
            if (isRightChild()) {
                return parent.left;
            }
            return null;
        }

    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>) node).element;
    }
}
