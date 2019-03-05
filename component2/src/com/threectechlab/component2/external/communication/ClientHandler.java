package com.threectechlab.component2.external.communication;

import com.threectechlab.component2.concurrent.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
    https://www.baeldung.com/a-guide-to-java-sockets
 */
public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private Printer printer;


    ClientHandler(final Socket socket) {
        this.clientSocket = socket;
        this.printer = new Printer();
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (".".equals(inputLine)) {
                    out.println("bye");
                    break;
                } else {
                    final String response = printer.convertPrint(inputLine);
                    out.println(response);
                }
            }

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
