package com.luoyan.actomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    public static AtomicReference<User> atomicUser = new AtomicReference<>();

    public static void main(String[] args) {

        User user = new User("beidou", 22);
        atomicUser.set(user);
        User daughter = new User("luoyan", 1);
        atomicUser.compareAndSet(user, daughter);

        System.out.println(atomicUser.get().getName());
        System.out.println(atomicUser.get().getAge());

    }

    static class User {
        private String name;

        private Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}

