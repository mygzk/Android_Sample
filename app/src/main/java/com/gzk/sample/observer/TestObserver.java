package com.gzk.sample.observer;

/**
 * Created by gzhenk on 16-2-26.
 */
public class TestObserver {
    public static void main(String[] args){
        BufferData bd= new BufferData();
        bd.registerObserver(new ContentObserver1());
        bd.registerObserver(new ContentObserver2());

        bd.notifyObservers();
    }
}
