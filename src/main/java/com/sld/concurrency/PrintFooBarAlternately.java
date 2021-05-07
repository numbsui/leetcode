package com.sld.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sld
 * <p>
 * leetcode 1115
 * https://leetcode.com/problems/print-foobar-alternately/
 */
public class PrintFooBarAlternately {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> System.out.print("foo"));
        Thread t2 = new Thread(() -> System.out.print("bar"));

        FooBar fooBar = new FooBar(100);

        new Thread(() -> {
            try {
                fooBar.foo(t1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                fooBar.bar(t2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }


    static class FooBar {
        private int n;
        private Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        private boolean flag = false;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                lock.lock();
                if (flag) {
                    condition2.await();
                }
                printFoo.run();
                flag = true;
                condition1.signalAll();
                lock.unlock();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                lock.lock();
                if (!flag) {
                    condition1.await();
                }
                printBar.run();
                flag = false;
                condition2.signalAll();
                lock.unlock();
            }
        }
    }

    /*static class FooBar {
        private int n;
        private Semaphore semaphore1;
        private Semaphore semaphore2;

        public FooBar(int n) {
            this.n = n;
            semaphore1 = new Semaphore(0);
            semaphore2 = new Semaphore(1);
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                semaphore2.acquire();
                printFoo.run();
                semaphore1.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                semaphore1.acquire();
                printBar.run();
                semaphore2.release();
            }
        }
    }*/
}
