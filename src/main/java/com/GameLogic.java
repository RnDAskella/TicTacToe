package main.java.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameLogic {
    Field f = new Field();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    void start() throws IOException {
        while (checkWinHuman() && checkWinPC()) {
            turnHuman();
            f.OutTable();
            if (!checkWinHuman()) {
                break;
            }
            turnPC();
            f.OutTable();
            if (!checkWinPC()) {
                break;
            }
        }
        System.out.println("ИГРА ОКОНЧЕНА");
        if (!checkWinHuman())
            System.out.println("ВЫ ПОБЕДИЛИ");
        else
            System.out.println("ВЫ ПРОИГРАЛИ");
    }

    void generalTurn() throws IOException {
        turnHuman();
        f.OutTable();
        checkWinHuman();
        turnPC();
        f.OutTable();
        checkWinPC();
    }

    void turnHuman() throws IOException {
        System.out.println("Enter the number from 0 to 9.");
        int x = Integer.parseInt(reader.readLine());
        while (f.getTABLE()[x - 1].equals(f.getHUMAN_SIGN()) || f.getTABLE()[x - 1].equals(f.getPC_SIGN())) {
            System.out.println("Enter the number from 0 to 9.");
            x = Integer.parseInt(reader.readLine());
        }
        f.getTABLE()[x - 1] = f.getHUMAN_SIGN();
    }


    void turnPC() {
        int x = (int) (Math.random() * 9);
        while ((f.getTABLE()[x].equals(f.getHUMAN_SIGN()) || f.getTABLE()[x].equals(f.getPC_SIGN()))) {
            x = (int) (Math.random() * 9);
        }
        f.getTABLE()[x] = f.getPC_SIGN();

    }


    private boolean checkWinHuman() {
        if (f.getTABLE()[0].equals(f.getTABLE()[1]) && f.getTABLE()[2].equals(f.getTABLE()[0]) && f.getTABLE()[0].equals(f.getHUMAN_SIGN()))
            return false;
        if (f.getTABLE()[0].equals(f.getTABLE()[1]) && f.getTABLE()[2].equals(f.getTABLE()[0]) && f.getTABLE()[0].equals(f.getHUMAN_SIGN())) {
            return false;
        } else if (f.getTABLE()[3].equals(f.getTABLE()[4]) && f.getTABLE()[4].equals(f.getTABLE()[5]) && f.getTABLE()[4].equals(f.getHUMAN_SIGN())) {
            return false;
        } else if (f.getTABLE()[6].equals(f.getTABLE()[7]) && f.getTABLE()[7].equals(f.getTABLE()[8]) && f.getTABLE()[8].equals(f.getHUMAN_SIGN())) {
            return false;
        } else if (f.getTABLE()[0].equals(f.getTABLE()[3]) && f.getTABLE()[3].equals(f.getTABLE()[6]) && f.getTABLE()[5].equals(f.getHUMAN_SIGN())) {
            return false;
        } else if (f.getTABLE()[1].equals(f.getTABLE()[4]) && f.getTABLE()[4].equals(f.getTABLE()[7]) && f.getTABLE()[7].equals(f.getHUMAN_SIGN())) {
            return false;
        } else if (f.getTABLE()[2].equals(f.getTABLE()[5]) && f.getTABLE()[5].equals(f.getTABLE()[8]) && f.getTABLE()[8].equals(f.getHUMAN_SIGN())) {
            return false;
        } else if (f.getTABLE()[0].equals(f.getTABLE()[4]) && f.getTABLE()[4].equals(f.getTABLE()[8]) && f.getTABLE()[0].equals(f.getHUMAN_SIGN())) {
            return false;
        } else if (f.getTABLE()[2].equals(f.getTABLE()[4]) && f.getTABLE()[4].equals(f.getTABLE()[6]) && f.getTABLE()[6].equals(f.getHUMAN_SIGN())) {
            return false;
        } else
            return true;
    }

    private boolean checkWinPC() {
        if (f.getTABLE()[0].equals(f.getTABLE()[1]) && f.getTABLE()[2].equals(f.getTABLE()[0]) && f.getTABLE()[0].equals(f.getPC_SIGN()))
            return false;
        if (f.getTABLE()[0].equals(f.getTABLE()[1]) && f.getTABLE()[2].equals(f.getTABLE()[0]) && f.getTABLE()[0].equals(f.getPC_SIGN())) {
            return false;
        } else if (f.getTABLE()[3].equals(f.getTABLE()[4]) && f.getTABLE()[4].equals(f.getTABLE()[5]) && f.getTABLE()[4].equals(f.getPC_SIGN())) {
            return false;
        } else if (f.getTABLE()[6].equals(f.getTABLE()[7]) && f.getTABLE()[7].equals(f.getTABLE()[8]) && f.getTABLE()[8].equals(f.getPC_SIGN())) {
            return false;
        } else if (f.getTABLE()[0].equals(f.getTABLE()[3]) && f.getTABLE()[3].equals(f.getTABLE()[6]) && f.getTABLE()[5].equals(f.getPC_SIGN())) {
            return false;
        } else if (f.getTABLE()[1].equals(f.getTABLE()[4]) && f.getTABLE()[4].equals(f.getTABLE()[7]) && f.getTABLE()[7].equals(f.getPC_SIGN())) {
            return false;
        } else if (f.getTABLE()[2].equals(f.getTABLE()[5]) && f.getTABLE()[5].equals(f.getTABLE()[8]) && f.getTABLE()[8].equals(f.getPC_SIGN())) {
            return false;
        } else if (f.getTABLE()[0].equals(f.getTABLE()[4]) && f.getTABLE()[4].equals(f.getTABLE()[8]) && f.getTABLE()[0].equals(f.getPC_SIGN())) {
            return false;
        } else if (f.getTABLE()[2].equals(f.getTABLE()[4]) && f.getTABLE()[4].equals(f.getTABLE()[6]) && f.getTABLE()[6].equals(f.getPC_SIGN())) {
            return false;
        } else
            return true;
    }

}
