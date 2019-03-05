package com.threectechlab.component1.console;

import com.threectechlab.component1.data.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputFrame implements Runnable {

    private Queue queue;

    public InputFrame(final Queue queue) {
        this.queue = queue;
    }


    public void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter Messages to Print in Component 2 : ");
            System.out.print("To Exit type 'exit' ");
            while (true) {
                String input = br.readLine();
                if ("exit".equals(input)) {
                    System.out.println("Exit!");
                    System.exit(0);
                }
                queue.enQueue(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
