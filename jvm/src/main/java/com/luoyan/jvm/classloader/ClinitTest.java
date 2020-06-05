package com.luoyan.jvm.classloader;

/**
 * class.forName 初始化  执行static方法块
 *
 * classLoader.loader 不触发初始化；可指定
 */
public class ClinitTest {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

//        MyObject object = new MyObject();

//        Child chil = new Child();
//
//        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        System.out.println(classLoader);
////
//        Class<?> clazz = classLoader.loadClass("com.luoyan.jvm.classloader.ClinitTest$MyObject");
//        System.out.println(clazz);
////
//        System.out.println(clazz.newInstance());

        Class.forName("com.luoyan.jvm.classloader.ClinitTest$MyObject");
    }

    static class MyObject {

        private static int x = 10;

        static {
            System.out.println(x);
            x++;
            y = 200;
//            System.out.println(y);
        }

        private static int y = 20;

        public MyObject() {
            System.out.println("constructor");
        }
    }


}

class Parent {
    static {
        System.out.println("Parent");
    }

    public Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {

    private static int x = 10;

    static {
        System.out.println("Child");
    }

    public Child() {
        System.out.println(" Child constructor");
    }
}



