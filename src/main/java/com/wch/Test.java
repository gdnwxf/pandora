package com.wch;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {

       final BlockingQueue queue = new ArrayBlockingQueue(5);

        Thread thread = new Thread(new Runnable() {
            public void run() {
                Object take = null;
                while (true) {
                    try {
                        System.out.println("dsads");
                        if (!((take = queue.take() )!=null)) break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                       continue;
                    }
                }
            }
        });
        thread.start();
        System.out.println("dsadsa");
        thread.interrupt();
    }
}
