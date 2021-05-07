package com.sld.concurrency;

import java.util.concurrent.Semaphore;

/**
 * @author sld
 * <p>
 * leetcode 1114
 * https://leetcode.com/problems/print-in-order/
 */
public class PrintInOrder {

    class Foo {

        Semaphore semaphore2;
        Semaphore semaphore3;

        public Foo() {
            semaphore2 = new Semaphore(0);
            semaphore3 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            printFirst.run();
            semaphore2.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            semaphore2.acquire();
            printSecond.run();
            semaphore3.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            semaphore3.acquire();
            printThird.run();
        }
    }
}
