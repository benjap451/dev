import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("ingrese las filas y columnas");
        int[][] matriz = { { 1, 2, 1 }, { 2, 1, 1 }, { 1, 1, 1 } };
        int fil = 0, col = 0;
        System.out.println(traspuesta(matriz, fil, col));
    }

    public static boolean traspuesta(int[][] matriz, int fil, int col) {
        boolean bool = true;
        if (matriz[fil][col] != matriz[col][fil]) {
            bool = false;
        } else {
            if (col < matriz[0].length - 1 && fil < matriz.length) {
                bool = traspuesta(matriz, fil, col + 1);
            } else if (col == matriz[0].length - 1 && fil < matriz.length - 1) {
                col = 0;
                bool = traspuesta(matriz, fil + 1, col);
            }
        }
        return bool;
    }
}
