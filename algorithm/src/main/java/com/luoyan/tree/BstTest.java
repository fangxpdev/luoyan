package com.luoyan.tree;

import com.luoyan.tree.printer.BinaryTrees;

import java.util.*;

public class BstTest {

    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
        test9();
    }

    static void test1() {
        Integer[] arr = new Integer[]{7, 4, 9, 2, 5, 8, 11, 12, 1};
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        BinaryTrees.println(bst);
    }


    static void test2() {

        Integer[] arr = new Integer[]{7, 4, 9, 2, 5, 8, 11, 12, 1};
        BST<Person> bst = new BST<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        for (int i = 0; i < arr.length; i++) {
            bst.add(new Person(arr[i]));
        }

        BinaryTrees.println(bst);

    }

    static void test3() {
        BST<Person> bst = new BST<>();
        bst.add(new Person(10, "he"));
        bst.add(new Person(9, "sk"));
        bst.add(new Person(12, "sf"));
        bst.add(new Person(9, "lina"));

        BinaryTrees.println(bst);
    }

    static void test4() {

        BST<Integer> bst = new BST<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            bst.add(random.nextInt(100));
        }
        BinaryTrees.println(bst);

        List<Integer> list = new ArrayList<>();
        bst.levelOrder(element -> list.add(element));

        System.out.println(list);

    }

    static void test5() {

        BST<Integer> bst = new BST<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            bst.add(random.nextInt(100));
        }
        BinaryTrees.println(bst);

        System.out.println(bst.height());

    }

    static void test6() {
        BST<Integer> bst = new BST<>();
        bst.add(86);
        bst.add(69);
        bst.add(95);
        bst.add(54);
        bst.add(90);
        BinaryTrees.println(bst);

        System.out.println(bst.isComplete2());
    }

    static void test7() {
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            bst.add(random.nextInt(100));
        }
        BinaryTrees.println(bst);

        System.out.println(bst.isComplete());
    }


    static void test8() {
        BST<Integer> bst = new BST<>();
        BinaryTrees.println(bst);

        System.out.println(bst.isComplete());
    }

    static void test9() {
        BST<Integer> bst = new BST<>();
        bst.add(86);
        bst.add(69);
        bst.add(70);
        bst.add(95);
        bst.add(54);
        bst.add(90);
        bst.add(92);
        BinaryTrees.println(bst);
        bst.remove(86);
        BinaryTrees.println(bst);
    }


}
