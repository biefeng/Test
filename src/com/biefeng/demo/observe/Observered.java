package com.biefeng.demo.observe;

import java.util.ArrayList;
import java.util.LinkedList;

public class Observered {
    private ArrayList<Observer> observers=new ArrayList<>();

    public void add(Observer observer){
        observers.add(observer);
    }

    public void delete(Observer observer){
        observers.remove(observer);
    }

    public void notifyAllObserver(){
        for(Observer observer:observers){
            observer.update();
        }
    }

    public static void main(String args[]){
        Observered observered = new Observered();
        Observer observer2 = new Observer1("Observer2");
        Observer observer1 = new Observer1("Observer1");
        observered.add(observer1);
        observered.add(observer2);
        observered.notifyAllObserver();
    }
}
