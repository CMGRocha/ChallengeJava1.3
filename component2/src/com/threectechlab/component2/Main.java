package com.threectechlab.component2;

import com.threectechlab.component2.external.communication.CommunicationServer;

import java.io.IOException;

public class Main {

    private static final int PORT = 3456;

    public static void main(String[] args) {
        // write your code here
        CommunicationServer server = new CommunicationServer();
        try {
            server.start(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
