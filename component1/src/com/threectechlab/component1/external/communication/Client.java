package com.threectechlab.component1.external.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
https://www.baeldung.com/a-guide-to-java-sockets
 */
public class Client {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    /*
    https://myshittycode.com/2014/03/26/findbug-solving-dm_default_encoding-warning-when-using-filewriter/
     */
    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        return in.readLine();
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}
