import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int i = 0;
        System.out.println("Ingrese el dividendo");
        int a = teclado.nextInt();
        System.out.println("Ingrese el divisor:");
        int b = teclado.nextInt();
        calculo(a, b, i);
    }

    public static void calculo(int a, int b, int i) {
        if (a >= b) {
            a = a - b;
            i = i + 1;
            calculo(a, b, i);
        } else {
            System.out.println("el resto es: " + a + " el cociente es: " + i);
        }

    }
}
