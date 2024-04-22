import java.util.Scanner;

public class App {
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int i = 0, j = 0, num = 0;
        char[][] letras;
        System.out.print("ingrese la dimesion de la matriz: ");
        i = teclado.nextInt();
        letras = new char[i][i];
        carga(letras);
        System.out.println("su matriz es: ");
        mostrar(letras);

    }

    public static void carga(char[][] letras) {
        char caracter;
        for (int fil = 0; fil < letras.length; fil++) {
            for (int col = 0; col < letras[0].length; col++) {
                System.out.println("ingrese un numero: " + "fila: " + fil + " columna: " + col);
                caracter = teclado.next().charAt(0);
                letras[fil][col] = caracter;
            }
        }
    }

    public static void mostrar(char[][] letras) {
        for (int fil = 0; fil < letras.length; fil++) {
            for (int col = 0; col < letras[0].length; col++) {
                if (fil == col) {
                    System.out.print(letras[fil][col]);
                }
            }
            System.out.println(" ");
        }
    }
}
