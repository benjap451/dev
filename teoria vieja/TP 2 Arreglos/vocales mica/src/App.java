import java.util.Scanner;
public class App {
    public static void main(String[] args)  {
        Scanner teclado= new Scanner(System.in);
        int k=0, j=0;
        System.out.println("Ingrese el largo de su arreglo: ");
        k= teclado.nextInt();
        char[] arreglo= new char[k];
        arreglo= armar(k, teclado);
        caracteres(arreglo);

    }

    public static char[] armar(int k, Scanner teclado){
        char a;
        char[] arreglo2= new char[k];
        for (int i = 0; i < arreglo2.length; i++) {
            System.out.println("ingrese un caracter: ");
            a=teclado.next().charAt(0);
            arreglo2[i]=a;
        }
        return arreglo2;
    }

    public static void caracteres(char[] arreglo){
        int j=0;
        char a;
        String cad= " ";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i]=='A' || arreglo[i]=='E' || arreglo[i]=='I' || arreglo[i]=='O' || arreglo[i]=='U'){
                j++;
                a=arreglo[i];
                cad=cad+a;
            }
        }
        char [] array= new char[j];
        for (int i = 0; i <j; i++) {
            a=cad.charAt(i+1);
            array[i]=a;
        }
        System.out.println("el arreglo de solo vocales es: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+ " ");
        }
    }
}
