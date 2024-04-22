import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner teclado = new Scanner(System.in);
        int matriz[][];
        int[] array;
        int fil, col, pos = 0;
        System.out.println("ingrese fila:");
        fil = teclado.nextInt();
        System.out.println("ingerse col:");
        col = teclado.nextInt();
        matriz = new int[fil][col];
        array = new int[fil];
        cargarMatriz(matriz);
        pos = sumarCol(matriz);
        array = cargarArreglo(matriz, pos);
        mostrarMatriz(matriz);
        System.out.println("el arreglo es:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] cargarArreglo(int[][] matriz, int pos) {
        int[] array = new int[matriz.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = matriz[i][pos] * -1;
        }
        return array;
    }

    public static int sumarCol(int[][] matriz) {
        int acumulador = 0, resultado = 0, k = 0, i = 0, j = 0;
        for (i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz[0].length; j++) {
                acumulador += matriz[j][i];
            }
            if (acumulador > resultado) {
                resultado = acumulador;
                k = i;
            }
            acumulador = 0;
        }
        return k;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void cargarMatriz(int[][] matriz) {
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("ingrese el valor:");
                matriz[i][j] = teclado.nextInt();
            }
        }
    }
}
