package com.luoyan.jvm.classloader;

import java.io.*;

/**
 * 运行需要删除 编译好的Person.class 复制将会用APPClassLoader加载Person.class
 */
public class MyClassLoader extends ClassLoader {

    private String path;

    public MyClassLoader(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytes = loadClassData(name);

            return defineClass(name, bytes, 0, bytes.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] loadClassData(String name) throws IOException {
        // load the class data from the connection
        String className = name.substring(name.lastIndexOf('.') + 1, name.length()) + ".class";

        String fileName = path + className;
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = fileInputStream.read(buffer)) > 0) {
            byteArrayOutputStream.write(buffer, 0, length);
        }
        return byteArrayOutputStream.toByteArray();

    }

    public static void main(String[] args) throws ClassNotFoundException {

        MyClassLoader classLoader = new MyClassLoader("/Users/michael/Documents/idea/com/luoyan/jvm/classloader/");

        String name = "com.luoyan.jvm.classloader.Person";
        Class<?> person = classLoader.loadClass(name);
        System.out.println(person.getClassLoader());


    }


}
