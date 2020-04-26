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
    private Field f;
    BufferedReader reader;
    private String s;
    private int x;

    void start() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        welcomeWindow();
        System.out.println("Your turn! Press numbers from 1 to 9. Please, don't repeat.");
        f = new Field(FIELD_DIM_X, FIELD_DIM_Y, EMPTY);
        while (checkWin()) {
            turnHuman();
            f.outTable();
            if (!checkWin()) {
                System.out.println(FINISH_GAME);
                System.out.println(HUMAN_WIN);
                continue;
            }
            turnPC();
            f.outTable();
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
        while (!checkCorTurnHuman() || (f.getTable()[x].equals(HUMAN_SIGN) || f.getTable()[x].equals(PC_SIGN))) {
            System.out.println("Enter the number from 0 to 8.");
            s = reader.readLine();
            if (checkCorTurnHuman()) {
                x = Integer.parseInt(s);
            }
        } // на этот цикл я потратил 3 часа!!! 3 часа, Карл.
        f.setTurn(x, HUMAN_SIGN);
    }

    boolean checkCorTurnHuman() {
        return s.equals("1") | s.equals("2") | s.equals("3") | s.equals("4") | s.equals("5") | s.equals("6") | s.equals("7") | s.equals("8") | s.equals("0");
    }

    void turnPC() {
        int x = (int) (Math.random() * 9);
        while ((f.getTable()[x].equals(EMPTY) && f.getTable()[x].equals(HUMAN_SIGN) || f.getTable()[x].equals(PC_SIGN))) {
            x = (int) (Math.random() * 9);
        }
        f.setTurn(x, PC_SIGN);
    }

    private boolean checkWin() {
        if (f.getTable()[0].equals(f.getTable()[1]) && f.getTable()[2].equals(f.getTable()[0]) && (f.getTable()[0].equals(HUMAN_SIGN) | f.getTable()[0].equals(PC_SIGN))) {
            return false;
        } else if (f.getTable()[3].equals(f.getTable()[4]) && f.getTable()[4].equals(f.getTable()[5]) && (f.getTable()[4].equals(HUMAN_SIGN) | f.getTable()[4].equals(PC_SIGN))) {
            return false;
        } else if (f.getTable()[6].equals(f.getTable()[7]) && f.getTable()[7].equals(f.getTable()[8]) && (f.getTable()[8].equals(HUMAN_SIGN) | f.getTable()[8].equals(PC_SIGN))) {
            return false;
        } else if (f.getTable()[0].equals(f.getTable()[3]) && f.getTable()[3].equals(f.getTable()[6]) && (f.getTable()[6].equals(HUMAN_SIGN) | f.getTable()[6].equals(PC_SIGN))) {
            return false;
        } else if (f.getTable()[1].equals(f.getTable()[4]) && f.getTable()[4].equals(f.getTable()[7]) && (f.getTable()[7].equals(HUMAN_SIGN) | f.getTable()[7].equals(PC_SIGN))) {
            return false;
        } else if (f.getTable()[2].equals(f.getTable()[5]) && f.getTable()[5].equals(f.getTable()[8]) && (f.getTable()[8].equals(HUMAN_SIGN) | f.getTable()[8].equals(PC_SIGN))) {
            return false;
        } else if (f.getTable()[0].equals(f.getTable()[4]) && f.getTable()[4].equals(f.getTable()[8]) && (f.getTable()[0].equals(HUMAN_SIGN) | f.getTable()[0].equals(PC_SIGN))) {
            return false;
        } else if (f.getTable()[2].equals(f.getTable()[4]) && f.getTable()[4].equals(f.getTable()[6]) && (f.getTable()[6].equals(HUMAN_SIGN) | f.getTable()[6].equals(PC_SIGN))) {
            return false;
        } else
            return true;
    } //
}
