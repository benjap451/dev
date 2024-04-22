import java.util.Scanner;

public class App {
    public static void cargarMatriz(int[][] matriz) {
        // Carga el arreglo bidimensional
        Scanner mod = new Scanner(System.in);
        int fil, col;
        for (fil = 0; fil < matriz.length; fil++) {
            for (col = 0; col < matriz[0].length; col++) {
                System.out.println("Ingrese valor de la fila " + (fil + 1)
                        + " columna " + (col + 1) + ":");
                matriz[fil][col] = mod.nextInt();
            }
        }
    }

    public static int[] arrColumna(int[][] matrizz, int columnaIng, int cantFilas) {
        // Carga arreglo con los valores de la columna (ingresada) de la matriz
        int[] arreglo;
        arreglo = new int[cantFilas];
        int fil, col, i = 0;
        for (fil = 0; fil <= cantFilas - 1; fil++) {
            for (col = 0; col <= matrizz[0].length; col++) {
                if (col == columnaIng - 1) {
                    arreglo[i] = matrizz[fil][columnaIng - 1];
                    i++;
                }
            }
        }
        return arreglo;
    }

    public static void main(String[] args) {
        // Dada una matriz, se genera un arreglo con los elementos de la columna dada
        Scanner sc = new Scanner(System.in);
        int[][] matrizIng;
        int cantFilas, cantColumnas, colElegida, i;
        int[] arregloColumnas;
        System.out.println("Ingrese la cantidad de filas de la matriz");
        cantFilas = sc.nextInt();
        System.out.println("Ingrese la cantidad de columnas de la matriz");
        cantColumnas = sc.nextInt();
        matrizIng = new int[cantFilas][cantColumnas];
        System.out.println("Ingrese la columna que desea mostrar como arreglo");
        colElegida = sc.nextInt();
        cargarMatriz(matrizIng);
        arregloColumnas = arrColumna(matrizIng, colElegida, cantFilas);
        System.out.println("La matriz generada es:");
        for (i = 0; i <= arregloColumnas.length - 1; i++) {
            System.out.print(arregloColumnas[i] + " ");
        }
    }
}
