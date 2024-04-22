import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        int i, n=0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("indique la longitud del arreglo: ");
        i = teclado.nextInt();
        char[] arreglo= new char[i];
        armar(arreglo, teclado);
        System.out.print("su arreglo es de longitud "+ arreglo.length+ " su arreglo es: ");
        mostrar(arreglo);
        
    }
    //muestra arreglo por pantalla
    public static void mostrar(char[] arreglo){
        int i=0;
        for (i=0; i<=arreglo.length-1; i++){
            System.out.print(arreglo[i]+ " ");
        }
    }
    //arma el arreglo
    public static void armar(char arreglo[], Scanner teclado){
        char letra;
        String cad=" ";
        for (int i = 0; i <= arreglo.length-1; i++) {
            System.out.println("ingrese su arreglo: ");
            letra = teclado.nextLine().charAt(i);
            cad= cad+letra;
            if (Character.isLetter(cad.charAt(i))){
                arreglo[i]= letra;
            }
        }
        
    }
}
