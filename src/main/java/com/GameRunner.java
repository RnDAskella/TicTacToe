package main.java.com;

import java.io.IOException;

public class GameRunner {
    public static void main(String[] args) throws IOException {
        WelcomeWindow ww = new WelcomeWindow();
        GameLogic gl = new GameLogic();
        gl.start();
    }
}
