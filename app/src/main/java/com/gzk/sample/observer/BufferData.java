package com.gzk.sample.observer;

import com.gzk.sample.observer.iml.Observer;
import com.gzk.sample.observer.iml.Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gzhenk on 16-2-26.
 */
public class BufferData implements Subject{
    private int onlinePlayersNum = 0; // store online players num
    private List<Observer> observers = new ArrayList<Observer>(); // refer to all observers

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = this.observers.indexOf(observer);
        if (i >= 0) {
            this.observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> iterator = this.observers.iterator();
        while (iterator.hasNext()) {
            iterator.next().update(this.onlinePlayersNum);
        }
    }

    public void setOnlinePlayersNum(int onlinePlayersNum) {
        this.onlinePlayersNum = onlinePlayersNum;
        this.notifyObservers();
    }

}
