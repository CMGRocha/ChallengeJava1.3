package com.threectechlab.component1.data;

import java.util.LinkedList;

public class QueueImpl implements Queue {

    private final Object lock = new Object();
    LinkedList content;

    QueueImpl() {
        content = new LinkedList();
    }

    public void enQueue(Object newObject) {
        synchronized (lock) {
            content.addLast(newObject);
        }
    }

    public Object deQueue() {
        synchronized (lock) {
            Object result = content.getFirst();
            content.removeFirst();
            return result;
        }
    }


    /*
    public synchronized void enQueue(final Object newObject) {
        content.addLast(newObject);
    }

    public synchronized Object deQueue() {
        Object result = content.getFirst();
        content.removeFirst();
        return result;
    }
    */
}
