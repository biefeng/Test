package com.biefeng.demo.thread.escape;



import java.util.List;

public class ListenerRunnable implements Runnable {

    private EventSource<EventListener> source;

    public ListenerRunnable(EventSource<EventListener> eventSource) {
        this.source = eventSource;
    }

    @Override
    public void run() {
        List<EventListener> listeners = null;
        try {
            listeners = this.source.retrieveListeners();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (EventListener listener : listeners) {
            listener.onEvent(new Object());
        }

    }
}
