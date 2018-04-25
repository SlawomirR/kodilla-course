package com.kodilla.patterns2.observer.forum;

public interface Observable {
    void registerObserver(Observer observer);
    void notifyObservers();
    void removerObserver(Observer observer);
}
