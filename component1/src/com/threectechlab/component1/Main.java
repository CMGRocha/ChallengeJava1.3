package com.threectechlab.component1;

import com.threectechlab.component1.concurrent.converter.SenderConverter;
import com.threectechlab.component1.console.InputFrame;
import com.threectechlab.component1.data.BlockingQueue;
import com.threectechlab.component1.data.Queue;

public class Main {

    private static final String LOCALHOST = "127.0.0.1";
    private static final int REMOTE_PORT = 3456;


    public static void main(String[] args) {
        final Queue queue = new BlockingQueue();
        final InputFrame inputFrame = new InputFrame(queue);
        final SenderConverter senderConverter = new SenderConverter(queue, LOCALHOST, REMOTE_PORT);

        final Thread inputFrameThread = new Thread(inputFrame);
        final Thread senderConverterThread = new Thread(senderConverter);
        inputFrameThread.start();
        senderConverterThread.start();
    }


}
