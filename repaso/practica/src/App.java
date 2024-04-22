import java.util.Scanner;

public class App {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int i = 0, j = 0, num = 0;
        int[][] numeros;
        System.out.print("ingrese la cantidad de filas: ");
        i = teclado.nextInt();
        System.out.print("ingrese la cantidad de columna: ");
        j = teclado.nextInt();
        numeros = new int[i][j];
        carga(numeros);
        System.out.println("su matriz es: ");
        mostrar(numeros);

    }

    public static void carga(int[][] numeros) {
        int num = 0;
        for (int fil = 0; fil < numeros.length; fil++) {
            for (int col = 0; col < numeros[0].length; col++) {
                System.out.println("ingrese un numero: " + "fila: " + fil + " columna: " + col);
                num = teclado.nextInt();
                numeros[fil][col] = num;
            }
        }
    }

    public static void mostrar(int[][] numeros) {
        for (int fil = 0; fil < numeros.length; fil++) {
            for (int col = 0; col < numeros[0].length; col++) {
                if (col == numeros[0].length - 1) {
                    System.out.print(col);
                } else {
                    System.out.print(numeros[fil][col] + "-");
                }
            }
            System.out.println(" ");
        }
    }
}