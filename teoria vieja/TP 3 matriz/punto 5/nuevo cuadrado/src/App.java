import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner teclado = new Scanner(System.in);
        int[][] matriz;
        matriz=new int[3][3];
        armar(matriz, teclado);
        mostrar(matriz);
        System.out.println("valor de las filas: "+evaFil(matriz));
        
    }
    //este modulo arma la matriz
    public static void armar(int[][] matriz, Scanner teclado){
        int fil=0, col;
        for (fil=0; fil<matriz.length; fil++){
            for (col=0; col<matriz.length; col++){
                System.out.println("ingrese el valor de fila "+(fil+1)+ " y el valor de la columna "+(col+1)+":");
                matriz[fil][col]= teclado.nextInt();
            }
        }
    }
    //este modulo muestra la matriz
    public static void mostrar(int [][] matriz){
        int fil, col;
        for (fil=0; fil<matriz.length; fil++){
            for (col=0; col<matriz.length-1; col++){
                System.out.print(matriz[fil][col]+ " ");
            }
            System.out.println(matriz[fil][col]+ " ");
        }
    }
    //Este modulo evalua la igualdad de las filas
    public static int evaFil (int [][] matriz){
        int fil=0, col=0, fila1=matriz[0][0], fila2=0, i=0;
        for ( fil = 0; fil < matriz.length; fil++) {
            for ( col = 0; col < matriz.length; col++) {
                if (matriz[0][0]==matriz[fil][col]){
                    i++;
                }
            }
        }
        return i;
    }
    //este modulo evalua la igualdad de las columnas
    public static int evaCol (int [][] matriz){
        boolean bool;
        int fil=0, col=0, col1=0, col2=0, col3=0, i=0;
        col1=matriz[0][0];
        for (col = 0; col < matriz.length; col++) {
            for (fil  = 0; fil < matriz.length; fil++) {
                col2=matriz[fil][col];
                if (col1==col2){
                    i++;
                }
            }
            
        }
        return i;
    }
    //este modulo evalua la igualdad de las diagonales
    public static int evaDiag (int [][] matriz){
        boolean bool=false;
        int sumdiag=0, sumdiag2=0, fil=0, col=0, sumTotal=0, sumaTotal2=0, i=2;
        for (fil=0; fil<matriz.length; fil++){
            sumdiag=sumdiag+matriz[fil][fil];
            sumdiag2=sumdiag2+matriz[fil][fil-matriz.length-1];
        }
        if (sumTotal==sumaTotal2){
            i++;
        }
        return i;
    }
}