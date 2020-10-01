package com.company.Multithreading;

import java.io.RandomAccessFile;

import static java.lang.Thread.sleep;

public class MultiExample {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Работает основная программа");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        myThread.start();
        runnable.run();


    }
}
