package com.threectechlab.component2.external.communication;

import com.threectechlab.component2.external.communication.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;

public class CommunicationServer {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true)
            new ClientHandler(serverSocket.accept()).run();
    }

    public void stop() throws IOException {
        serverSocket.close();
    }
}
