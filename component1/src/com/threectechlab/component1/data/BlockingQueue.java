package com.threectechlab.component1.data;

import java.util.LinkedList;

/*
    https://www.baeldung.com/java-concurrency-interview-questions
 */
public class BlockingQueue implements Queue {
    private LinkedList content;

    public BlockingQueue() {
        content = new LinkedList();
    }

    public synchronized void enQueue(final Object newObject) {
        content.addLast(newObject);
        notifyAll();
    }

    public synchronized Object deQueue() {
        while (content.isEmpty()) {
            try {
                wait();
            } catch (final InterruptedException e) {
            }
        }
        Object result = content.getFirst();
        content.removeFirst();
        return result;
    }

    public synchronized boolean isEmpty() {
        return content.isEmpty();
    }
}
