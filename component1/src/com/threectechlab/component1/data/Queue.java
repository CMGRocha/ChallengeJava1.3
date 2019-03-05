package com.threectechlab.component1.data;

public interface Queue {

    void enQueue(final Object newObject);

    Object deQueue();

    boolean isEmpty();
}
