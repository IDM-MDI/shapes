package edu.by.ishangulyev.shape.observer;

public interface CubeObservable
{
    void notifyObservers();
    void detach(CubeObserver observer);
    void attach(CubeObserver observer);
}
