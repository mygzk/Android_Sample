package com.example;

/**
 * Created by gzhenk on 16-2-25.
 */
public class Fruite {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
        }


        @Override
        public synchronized void start() {
            super.start();
        }

    }


    public void changeName() {
    }

    public void changeName(int q) {
    }

    public int changeName(int q, String s) {
        return 0;
    }



    protected int method1(int a, int b) { return 0; }


}
