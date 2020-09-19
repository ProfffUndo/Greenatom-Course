package com.company.Multithreading;

public class MyThread extends Thread{
    public void run() {
        while (true) {
            System.out.println("Асинхронный привет!");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            }
            System.out.println("Асинхронный пока!");
            try {
                sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
