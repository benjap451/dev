import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String palabra = "";
        armaPalabra(palabra);
    }

    public static char armaPalabra(String palabra) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese un caracter: ");
        char a = teclado.next().charAt(0);
        if (a != '.') {
            palabra = palabra + a;
            armaPalabra(palabra);
        } else {
            System.out.println("la palabra es: " + palabra);
        }
        return a;
    }
}
