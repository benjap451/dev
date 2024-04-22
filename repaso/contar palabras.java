import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String palabra;
        Scanner teclado = new Scanner(System.in);
        System.out.println("ingrese una palabra");
        palabra = teclado.nextLine();
        System.out.println(cantPalabras(palabra));
    }

    public static int cantPalabras(String palabra) {
        int cantidad = 0, i = 0;
        String corto;
        if (palabra.equalsIgnoreCase(" ")) {
            cantidad = 0;
        } else {
            do {
                palabra = palabra.trim();
                i = palabra.indexOf(" ");
                if (i > 0) {
                    palabra = palabra.substring(i);
                    cantidad++;
                } else {
                    cantidad++;
                }
            } while (i != -1);
        }
        return cantidad;
    }
}
