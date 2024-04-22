import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Scanner teclado = new Scanner(System.in);
        int[][] matriz;
        matriz=new int[3][3];
        armar(matriz, teclado);
        mostrar(matriz);
        System.out.println(evaFil(matriz)+" "+evaCol(matriz)+" "+evaDiag(matriz));
        
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
    public static boolean evaFil (int [][] matriz){
        int fil=0, col=0, fila1=0, fila2=0, fila3=0;
        boolean bool;
        for (col=0; col<=matriz.length-1; col++){
            fila1=fila1+matriz[fil][col];
        }
        fil++;
        for (col=0; col<matriz.length; col++){
            fila2=fila2+matriz[fil][col];
        }
        fil++;
        for (col=0; col<matriz.length; col++){
            fila3=fila3+matriz[fil][col];
        }
        if (fila1==fila2 && fila2==fila3){
            bool=true;
        } else {
            bool = false;
        }
        return bool;
    }
    //este modulo evalua la igualdad de las columnas
    public static boolean evaCol (int [][] matriz){
        boolean bool;
        int fil=0, col=0, col1=0, col2=0, col3=0;
        for (fil=0; fil<=matriz.length-1; fil++){
            col1=col1+matriz[fil][col];
        }
        col++;
        for (fil=0; fil<matriz.length; fil++){
            col2=col2+matriz[fil][col];
        }
        col++;
        for (fil=0; fil<matriz.length; fil++){
            col3=col3+matriz[fil][col];
        }
        if (col1==col2 && col2==col3){
            bool=true;
        } else {
            bool=false;
        }
        return bool;
    }
    //este modulo evalua la igualdad de las diagonales
    public static boolean evaDiag (int [][] matriz){
        boolean bool=false;
        int sumdiag=0, sumdiag2=0, fil=0, col=0, sumTotal=0, sumaTotal2=0;
        for (fil=0; fil<matriz.length; fil++){
            sumdiag=sumdiag+matriz[fil][fil];
            sumdiag2=sumdiag2+matriz[fil][fil-matriz.length-1];
        }
        if (sumTotal==sumaTotal2){
            bool=true;
        }
        return bool;
    }
}