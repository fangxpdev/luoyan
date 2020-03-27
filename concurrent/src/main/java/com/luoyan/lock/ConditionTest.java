package com.luoyan.lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private static final Lock lock = new ReentrantLock();

    private static final Condition produceCondition = lock.newCondition();

    private static final Condition consumeCondition = lock.newCondition();

    private static final LinkedList<Long> timestampPool = new LinkedList<>();




    public static void main(String[] args) {


    }

}
