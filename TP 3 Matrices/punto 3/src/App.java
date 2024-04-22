import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String[][] matriz;
        int i = 0, j = 0;
        System.out.println("Ingrese cant de oraciones");
        i = sc.nextInt();
        System.out.println("Ingrese cant de palabras");
        j = sc.nextInt();
        matriz = new String[i][j];
        cargarMatriz(matriz);
        mostrarMatriz(matriz);

    }

    public static void crearMatriz(String[][] matriz) {
        int i = 0, j = 0;
        System.out.println("Ingrese cant de oraciones");
        i = sc.nextInt();
        System.out.println("Ingrese cant de palabras");
        j = sc.nextInt();
        matriz = new String[i][j];
    }

    public static void cargarMatriz(String[][] matriz) {
        Scanner teclado = new Scanner(System.in);
        int i = 0, j = 0, col = matriz[0].length;
        String oracion, pal;
        String[] palabras;
        for (i = 0; i < matriz.length; i++) {
            System.out.println("ingrese su oracion:");
            oracion = teclado.nextLine();
            palabras = oracion.split(" ");
            for (j = 0; j < matriz[0].length; j++) {
                pal = palabras[j];
                matriz[i][j] = pal;
            }
        }
    }

    public static void mostrarMatriz(String[][] matriz) {
        boolean continuar = true;
        String resp;
        int i, j;
        while (continuar) {
            System.out.println("ingrese nro de oracion");
            i = sc.nextInt() - 1;
            System.out.println("ingrese nro de palabra");
            j = sc.nextInt() - 1;
            System.out.println(matriz[i][j]);
            System.out.println("desea continuar, si/no");
            resp = sc.next();
            if (resp.equalsIgnoreCase("si")) {
                continuar = true;
            } else {
                continuar = false;
            }

        }
    }

}
