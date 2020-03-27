package com.luoyan;

/**
 * 查看汇编代码
 * -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
 *
 * 1. 下载hsdis-amd64.dylib放到jre/lib包下
 * 2. 指定代码的jvm参数添加  -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
 * 3. console查看汇编代码
 * 4. 参加/Users/michael/dev/demo/luoyan/concurrent/src/main/java/com/luoyan/VolatileTest.java
 */
public class VolatileTest {

    private static volatile Singleton instance;

    public static void main(String[] args) {
        instance = new Singleton();
        System.out.println("111");
    }

}
