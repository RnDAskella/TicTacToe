package main.java.com;

public class Field {
    private String[] TABLE;
    private final String EMPTY = "|_|";
    private final String HUMAN_SIGN = "|X|";
    private final String PC_SIGN = "|O|";
    private final int FIELD_DIM_X = 3;
    private final int FIELD_DIM_Y = 3;


    public Field() {
        TABLE = new String[FIELD_DIM_X * FIELD_DIM_Y];
        for (int i = 0; i < TABLE.length; i++) {
            TABLE[i] = EMPTY;
        }
        OutTable();
        System.out.println("Your turn! Press numbers from 1 to 9. Please, don't repeat.");
    }

    public void OutTable() {
        for (int i = 0; i < TABLE.length; i++) {
            if ( i == 3 || i == 6) {
                System.out.println();
            }
            System.out.print(TABLE[i] + " ");
        }
        System.out.println();
        System.out.println("------------------------------------------");
    }

     static void clearScreen() {
         for (int i = 0; i < 20; i++) {
             System.out.println();
         }
     }

    public String[] getTABLE() {
        return TABLE;
    }

    public String getHUMAN_SIGN() {
        return HUMAN_SIGN;
    }

    public String getPC_SIGN() {
        return PC_SIGN;
    }
}

