package com.luoyan.jvm;

/**
 * 逃逸分析
 * -XX:+PrintGCDetails -Xms5M -Xmx5M -XX:-DoEscapeAnalysis
 * 是否在栈上直接分配
 */
public class EscapeTest {

    public static void main(String[] args){
        for(int i = 0; i < 5_000_000; i++){
            createObject();
        }
    }

    public static void createObject(){
        new Object();
    }
}
