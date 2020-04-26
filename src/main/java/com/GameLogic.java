package main.java.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameLogic {
    private final String HUMAN_SIGN = "|X|";
    private final String PC_SIGN = "|O|";
    private final int FIELD_DIM_X = 3;
    private final int FIELD_DIM_Y = 3;
    private final String EMPTY = "|_|";
    private final String FINISH_GAME = "FINISH";
    private final String PC_WIN = "YOU LOSE! TRY AGAIN!";
    private final String HUMAN_WIN = "YOU WIN!!";
    private Field gameField;
    private BufferedReader reader;
    private String s;
    private int x;

    void start() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        welcomeWindow();
        System.out.println("Your turn! Press numbers from 1 to 9. Please, don't repeat.");
        gameField = new Field(FIELD_DIM_X, FIELD_DIM_Y, EMPTY);
        while (checkWin()) {
            turnHuman();
            gameField.outTable();
            if (!checkWin()) {
                System.out.println(FINISH_GAME);
                System.out.println(HUMAN_WIN);
                continue;
            }
            turnPC();
            gameField.outTable();
            if (!checkWin()) {
                System.out.println(FINISH_GAME);
                System.out.println(PC_WIN);
            }
        }
    }

    void welcomeWindow() throws IOException {
        System.out.println("WELCOME");
        System.out.println("This game is TicTacToe. You against PC!");
        System.out.println("You have 'X' sign");
        System.out.println("GOOD LUCK");
        System.out.println("TYPING 'start' for begin");
        System.out.println();

        s = reader.readLine();

        while (!s.equals("start")) {
            System.out.println("TYPING - start");
            s = reader.readLine();
        }
    }

    void turnHuman() throws IOException {
        System.out.println("Enter the number from 0 to 8.");
        s = reader.readLine();
        if (checkCorTurnHuman()) {
            x = Integer.parseInt(s);
        }
        while (!checkCorTurnHuman() || (gameField.getTable()[x].equals(HUMAN_SIGN) || gameField.getTable()[x].equals(PC_SIGN))) {
            System.out.println("Enter the number from 0 to 8.");
            s = reader.readLine();
            if (checkCorTurnHuman()) {
                x = Integer.parseInt(s);
            }
        } // на этот цикл я потратил 3 часа!!! 3 часа, Карл.
        gameField.setTurn(x, HUMAN_SIGN);
    }

    boolean checkCorTurnHuman() {
        return s.equals("1") | s.equals("2") | s.equals("3") | s.equals("4") | s.equals("5") | s.equals("6") | s.equals("7") | s.equals("8") | s.equals("0");
    }

    void turnPC() {
        int x = (int) (Math.random() * 9);
        while ((gameField.getTable()[x].equals(EMPTY) && gameField.getTable()[x].equals(HUMAN_SIGN) || gameField.getTable()[x].equals(PC_SIGN))) {
            x = (int) (Math.random() * 9);
        }
        gameField.setTurn(x, PC_SIGN);
    }

    private boolean checkWin() {
        if (gameField.getTable()[0].equals(gameField.getTable()[1]) && gameField.getTable()[2].equals(gameField.getTable()[0]) && (gameField.getTable()[0].equals(HUMAN_SIGN) | gameField.getTable()[0].equals(PC_SIGN))) {
            return false;
        } else if (gameField.getTable()[3].equals(gameField.getTable()[4]) && gameField.getTable()[4].equals(gameField.getTable()[5]) && (gameField.getTable()[4].equals(HUMAN_SIGN) | gameField.getTable()[4].equals(PC_SIGN))) {
            return false;
        } else if (gameField.getTable()[6].equals(gameField.getTable()[7]) && gameField.getTable()[7].equals(gameField.getTable()[8]) && (gameField.getTable()[8].equals(HUMAN_SIGN) | gameField.getTable()[8].equals(PC_SIGN))) {
            return false;
        } else if (gameField.getTable()[0].equals(gameField.getTable()[3]) && gameField.getTable()[3].equals(gameField.getTable()[6]) && (gameField.getTable()[6].equals(HUMAN_SIGN) | gameField.getTable()[6].equals(PC_SIGN))) {
            return false;
        } else if (gameField.getTable()[1].equals(gameField.getTable()[4]) && gameField.getTable()[4].equals(gameField.getTable()[7]) && (gameField.getTable()[7].equals(HUMAN_SIGN) | gameField.getTable()[7].equals(PC_SIGN))) {
            return false;
        } else if (gameField.getTable()[2].equals(gameField.getTable()[5]) && gameField.getTable()[5].equals(gameField.getTable()[8]) && (gameField.getTable()[8].equals(HUMAN_SIGN) | gameField.getTable()[8].equals(PC_SIGN))) {
            return false;
        } else if (gameField.getTable()[0].equals(gameField.getTable()[4]) && gameField.getTable()[4].equals(gameField.getTable()[8]) && (gameField.getTable()[0].equals(HUMAN_SIGN) | gameField.getTable()[0].equals(PC_SIGN))) {
            return false;
        } else if (gameField.getTable()[2].equals(gameField.getTable()[4]) && gameField.getTable()[4].equals(gameField.getTable()[6]) && (gameField.getTable()[6].equals(HUMAN_SIGN) | gameField.getTable()[6].equals(PC_SIGN))) {
            return false;
        } else
            return true;
    } //
}
