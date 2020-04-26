package main.java.com;

public class Field {
    private String[] table;

    public Field(int dimX, int dimY, String z) {
        table = new String[dimX * dimY];
        for (int i = 0; i < table.length; i++) {
            table[i] = z;
        }
        outTable();
    }

    public void outTable() {
        for (int i = 0; i < table.length; i++) {
            if ( i == 3 || i == 6) {
                System.out.println();
            }
            System.out.print(table[i] + " ");
        }
        System.out.println();
        System.out.println("------------------------------------------");
    }

    public String[] getTable() {
        return table;
    }

    public void setTurn(int slot, String sign){
        table[slot] = sign;
    }
}

