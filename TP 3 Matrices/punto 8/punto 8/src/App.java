import java.util.Scanner;

public class App {
    // Dada una matriz de números enteros de dimensión NxN,
    // se desea verificar si la matriz es simétrica o antisimétrica con
    // respecto a la diagonal principal. Implemente un algoritmo que
    // luego de cargar una matriz realice la verificación solicitada
    // y muestre por pantalla un cartel adecuado.
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int[][] num;
        int n;
        boolean b1;
        System.out.print("ingrese dimension de la matriz: ");
        n = teclado.nextInt();
        System.out.println("--------------------");
        num = new int[n][n];
        cargar(num);
        b1 = comparar(num);
        if (b1 == true) {
            System.out.println("la matriz es simetrica");
        } else {
            System.out.println("la matriz no es simetrica");
        }
    }

    // este modulo se encarga de comparar los elementos
    // fuera de la diagonal principal, retornando falso cuando encuentre
    // el primer caso distinto
    public static boolean comparar(int[][] num) {
        boolean b1 = true;
        int fil = 0, col = 0;
        while (fil < num.length && b1 == true) {
            while (col < num[0].length && b1 == true) {
                if (fil != col) {
                    if (num[fil][col] != num[col][fil]) {
                        b1 = false;
                    }
                }
                col++;
            }
            fil++;
        }
        return b1;
    }

    // este modulo realiza la carga de la matriz
    public static void cargar(int[][] num) {
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[0].length; j++) {
                System.out.print("ingrese un numero: ");
                num[i][j] = teclado.nextInt();
                System.out.println("----------------");
            }
        }
    }
}
