import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int [][] matriz;
        int i=0;
        System.out.println("ingrese las filas: ");
        int fil=teclado.nextInt();
        System.out.println("ingrese las columnas: ");
        int col=teclado.nextInt();
        matriz=cargar(fil, col, teclado);
        mostrar(matriz);
        recorrerMatriz(matriz, i);
    }

    public static int[][] cargar(int fil, int col, Scanner teclado){
        int [][] matrizz= new int[fil][col];
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("ingrese un numero: ");
                matrizz[i][j]=teclado.nextInt();
            }
        }
        return matrizz;
    }
    public static void mostrar(int [][]matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println(" ");
        }
    }

    public static void recorrerMatriz(int[][] matrizz, int i){
        int j=0, sum=0, m, comp=0, col=0;
        m=sumaFil(matrizz, i, col, comp);
        System.out.println(m);
        if (i<matrizz.length){
            recorrerMatriz(matrizz, i+1);
        }
    }

        public static int sumaFil(int[][] matrizz, int i, int col, int comp) {
            if (col == matrizz[0].length - 1) {
                comp = matrizz[i][col];
            } else if (col<matrizz[0].length) {
            comp = sumaFil(matrizz, i, col+1, comp);
                comp=comp+matrizz[i][col];
            }
            return comp;
        }

    }
