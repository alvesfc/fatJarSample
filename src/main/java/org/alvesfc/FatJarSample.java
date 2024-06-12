package org.alvesfc;

import java.util.Base64;

public class FatJarSample {

    public static void main(String[] args) {
        if (args.length == 2) {
            process(args);
        } else {
            System.out.println("Please provide a name as argument.  e.g. java -jar fat-jar-example.jar encode message");
        }
    }

    private static void process(String[] args) {
        switch (args[0].toLowerCase()) {
            case "encode":
                System.out.println(Base64.getEncoder().encodeToString(args[1].getBytes()));
                break;
            case "decode":
                System.out.println(new String(Base64.getDecoder().decode(args[1])));
                break;
            default:
                System.out.println("Invalid command. Please use encode or decode");
                break;
        }
    }
}
