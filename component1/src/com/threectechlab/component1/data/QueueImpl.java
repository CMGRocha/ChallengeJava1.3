package com.threectechlab.component1.data;

import java.util.LinkedList;

/*
    https://stackoverflow.com/questions/11149707/best-implementation-of-java-queue
 */
public class QueueImpl implements Queue {

    private final Object lock = new Object();
    private LinkedList content;

    public QueueImpl() {
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

    public boolean isEmpty() {
        synchronized (lock) {
            return content.isEmpty();
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
