package main.java.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WelcomeWindow {
    WelcomeWindow() throws IOException {
        System.out.println("WELCOME");
        System.out.println("This game is TicTacToe. You against PC!");
        System.out.println("You have 'X' sign");
        System.out.println("GOOD LUCK");
        System.out.println("TYPING 'start' for begin");
        System.out.println();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        while (!s.equals("start")) {
            System.out.println("TYPING - start");
            s = reader.readLine();
        }
        Field.clearScreen();
    }

}
