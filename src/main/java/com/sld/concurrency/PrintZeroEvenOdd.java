package com.sld.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author sld
 * <p>
 * leetcode 1116
 * https://leetcode.com/problems/print-zero-even-odd/
 */
public class PrintZeroEvenOdd {


    static class ZeroEvenOdd {
        private int n;
        private Semaphore semaphore = new Semaphore(1);
        private Semaphore semaphore2 = new Semaphore(0);
        private Semaphore semaphore3 = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                semaphore.acquire();
                printNumber.accept(0);
                if (i % 2 == 0) {
                    semaphore3.release();
                } else {
                    semaphore2.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    semaphore3.acquire();
                    printNumber.accept(i);
                    semaphore.release();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    semaphore2.acquire();
                    printNumber.accept(i);
                    semaphore.release();
                }
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
