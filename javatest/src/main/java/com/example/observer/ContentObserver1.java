package com.example.observer;


import com.example.observer.iml.Observer;

/**
 * Created by gzhenk on 16-2-26.
 */
public class ContentObserver1 implements Observer {

    int onlineNum= 0;

    @Override
    public void update(int onlineNum) {
        this.onlineNum = onlineNum;

        System.out.println("ContentObserver1 onlineNum:"+onlineNum);
    }
}
