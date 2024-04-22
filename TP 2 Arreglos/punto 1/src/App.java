import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int i;
        char a;
        System.out.println("ingrese la cantidad de caracteres:");
        i = teclado.nextInt();
        char[] caracteres = new char[i];
        for (int j = 0; j <= caracteres.length - 1; j++) {
            System.out.println("ingrese un caracter:");
            a = teclado.next().charAt(0);
            caracteres[j] = a;
        }
        mostrar(caracteres);
    }

    public static void mostrar(char[] caracteres) {
        int orden;
        Scanner teclado = new Scanner(System.in);
        System.out.println("indique el orden de impresion: orden ingresado(1) o invertido(2)?");
        orden = teclado.nextInt();
        int p = caracteres.length - 1;
        if (orden == 1) {
            for (int i = 0; i < caracteres.length; i++) {
                System.out.print(caracteres[i] + ", ");
            }
        }
        if (orden == 2) {
            for (int i = 0; i < caracteres.length; i++) {
                System.out.print(caracteres[i] + ", ");
                p -= 1;
            }
        }
    }
}
