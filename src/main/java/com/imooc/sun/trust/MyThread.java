package com.imooc.sun.trust;

public class MyThread extends Thread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        System.out.println("one");
        t2.start();
        System.out.println("two");
    }

    public void run() {
        System.out.println("Thread");
    }

//    ObjectInputStream
//    RandomAccessFile
//    Throwable
//    Collection
}

