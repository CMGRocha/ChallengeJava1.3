package com.threectechlab.component2.concurrent;

public class Printer {

    public String convertPrint(final String message) {
        try {
            //System.out.println("Message Received : " + message);
            final String decodedMessage = decode(message);
            System.out.println("Printed from Component 1 : " + decodedMessage);
            return "Printed Successfully";
        } catch (final Exception ex) {
            return "Unsuccessful. Message was not printed.";
        }
    }

    /*
    https://www.baeldung.com/java-convert-hex-to-ascii
     */
    private String decode(String message) {
        StringBuffer output = new StringBuffer();

        for (int i = 0; i < message.length(); i += 2) {
            String str = message.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }

        return output.toString();

    }
}
