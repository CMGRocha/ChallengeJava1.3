package com.threectechlab.component1;

import com.threectechlab.component1.external.communication.Client;

import java.io.IOException;

public class Main {

    private static final String LOCALHOST = "127.0.0.1";
    private static final int REMOTE_PORT = 3456;



    public static void main(String[] args) {
        try {
            final Client client = new Client();
            client.startConnection(LOCALHOST, REMOTE_PORT);
            final String response = client.sendMessage("hello Component 2");
            client.sendMessage("Bye Now");
            client.sendMessage(".");
            client.stopConnection();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
