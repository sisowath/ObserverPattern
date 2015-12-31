package com.samnang.classes;

public interface Sujet {
    public void registerObserver(Observer observateur);
    public void removeObserver(Observer observateur);
    public void notifyObservers();
}
