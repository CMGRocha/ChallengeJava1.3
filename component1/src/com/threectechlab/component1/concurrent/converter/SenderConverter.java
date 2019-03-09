package com.threectechlab.component1.concurrent.converter;

import com.threectechlab.component1.data.Queue;
import com.threectechlab.component1.external.communication.Client;

import java.io.IOException;

public class SenderConverter implements Runnable {

    private Queue queue;
    private String localHost;
    private int remotePort;

    public SenderConverter(final Queue queue, final String localHost, final int remotePort) {
        this.queue = queue;
        this.localHost = localHost;
        this.remotePort = remotePort;
    }

    public void run() {

        while (true) {
            if (!queue.isEmpty()) {
                String message = (String) queue.deQueue();
                //System.out.println("Message from queue : " + message);

                String messageEncoded = encodeMessage(message);
                //System.out.println("Encoded Message : " + messageEncoded);

                String response = sendToComponent2(messageEncoded);
                //System.out.println("Component 2 Replied with : " + response);
            }
        }

    }

    /*
    https://www.baeldung.com/java-convert-hex-to-ascii
     */
    private String encodeMessage(String message) {
        char[] chars = message.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
            char ch = chars[i];
            buffer.append(Integer.toHexString((int) ch));
        }
        return buffer.toString();
    }

    private String sendToComponent2(final String messageToSend) {
        try {
            final Client client = new Client();
            client.startConnection(localHost, remotePort);
            final String response = client.sendMessage(messageToSend);
            client.sendMessage(".");
            client.stopConnection();
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Error";
    }
}
