public class App {
    // Diseñar módulos para mostrar una matriz numérica según diferentes recorridos:
    // a. Por filas de atrás hacia adelante
    // b. Por columnas de arriba hacia abajo
    // c. En espiral (ver fig. 1)
    // d. En zig-zag (ver fig. 2)
    public static void main(String[] args) throws Exception {
        int fil = 0, col = 0;
        int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("mostramos la matriz a trabajar:");
        mostrar(matriz);
        System.out.println("-----------------------");
        System.out.println("muestra la matriz por filas de atras hacia adelante:");
        puntoA(matriz);
        System.out.println("-----------------------");
        System.out.println("muestra la matriz por columnas de arriba hacia abajo:");
        puntoB(matriz);
        System.out.println("-----------------------");
        System.out.println("muestra la matriz en espiral");
        puntoC(matriz);
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("muestra la matriz en zig-zag:");
        puntoD(matriz);

    }

    public static void mostrar(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void puntoA(int[][] matriz) {
        for (int fil = 0; fil < matriz.length; fil++) {
            for (int col = matriz[0].length - 1; col >= 0; col--) {
                System.out.print(matriz[fil][col] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void puntoB(int[][] matriz) {
        for (int col = 0; col < matriz[0].length; col++) {
            for (int fil = 0; fil < matriz.length; fil++) {
                System.out.print(matriz[fil][col] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void puntoC(int[][] matriz) {
        int fil = matriz.length, col = matriz[0].length, filaInicio = 0, columnaInicio = 0;
        while (filaInicio < fil && columnaInicio < col) {
            for (int i = columnaInicio; i < col; i++) {
                System.out.print(matriz[filaInicio][i] + " ");
            }
            filaInicio++;

            for (int i = filaInicio; i < fil; i++) {
                System.out.print(matriz[i][col - 1] + " ");
            }
            col--;

            if (filaInicio < fil) {
                for (int i = col - 1; i >= columnaInicio; i--) {
                    System.out.print(matriz[fil - 1][i] + " ");
                }
                fil--;
            }

            if (columnaInicio < col) {
                for (int i = fil - 1; i >= filaInicio; i--) {
                    System.out.print(matriz[i][columnaInicio] + " ");
                }
                columnaInicio++;
            }
        }
    }

    public static void puntoD(int[][] matriz) {
        int fil = 0;

        while (fil < matriz.length) {
            for (int i = 0; i < matriz[0].length; i++) {
                System.out.print(matriz[fil][i] + " ");
            }
            System.out.println("");
            fil++;

            if (fil < matriz.length) {
                for (int i = matriz[0].length - 1; i >= 0; i--) {
                    System.out.print(matriz[fil][i] + " ");
                }
                System.out.println("");
                fil++;
            }
        }
    }
}
