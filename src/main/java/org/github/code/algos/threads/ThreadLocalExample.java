package org.github.code.algos.threads;

public class ThreadLocalExample {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            threadLocal.set("Thread 1");
            System.out.println(threadLocal.get()); // prints "Thread 1"
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set("Thread 2");
            System.out.println(threadLocal.get()); // prints "Thread 2"
        });

        thread1.start();
        thread2.start();
    }
}
