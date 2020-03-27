package com.luoyan.future;


/**
 * 角色：
 * Future -> 获取未来结果的凭证
 * FutureTask -> 隔离调用逻辑
 * FutureService -> 桥接 Futrue 和 FutureTask
 *
 * 两种模式 ：
 * 1. future.get() 需要等待结果,存在一定阻塞时间
 * 2. 回调方法
 * 任务执行完成，调用回调方法，调用方不用等待
 *
 */

public class InvokerTest {

    public static void main(String[] args) throws InterruptedException {

//        FutureService service = new FutureService();
//        Future<String> future = service.submit(() -> {
//            System.out.println("work start");
//            Thread.sleep(10000L);
//            System.out.println("work done");
//            return "LUOYAN";
//        });
//
//        System.out.println("------------");
//        System.out.println("---do other things----");
//        System.out.println("-------------");
//
//        System.out.println(future.get());
        FutureService service = new FutureService();
        Future<String> future = service.submit(() -> {
            System.out.println("work start");
            Thread.sleep(5000L);
            System.out.println("work done");
            return "LUOYAN";
        }, System.out::println);

        System.out.println("------------");
        System.out.println("---do other things----");
        System.out.println("-------------");

    }

}
