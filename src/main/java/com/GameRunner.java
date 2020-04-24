package main.java.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class GameRunner {
    public static void main(String[] args) throws IOException {
        System.out.println("WELCOME");
        System.out.println("This game is TicTacToe. You against PC!");
        System.out.println("You have 'X' sign");
        System.out.println("GOOD LUCK");
        System.out.println("TYPING 'start' for begin");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        while (!s.equals("start")){
            System.out.println("TYPING - start");
            s = reader.readLine();
        }
        System.out.flush();
        start();



    }

    private static void start() {
        System.out.println("test");
        Field f = new Field();
    }
}
