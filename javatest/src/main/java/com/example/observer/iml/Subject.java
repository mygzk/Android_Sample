package com.example.observer.iml;

/**
 * Created by gzhenk on 16-2-26.
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
