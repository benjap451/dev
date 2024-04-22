import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int n, p = 1;
        int[] multiplos = new int[10];
        Scanner teclado = new Scanner(System.in);
        System.out.println("ingrese un numero: ");
        n = teclado.nextInt();
        for (int i = 0; i < multiplos.length; i++) {
            multiplos[i] = n * p;
            p += 1;
        }
        for (int i = 0; i < multiplos.length; i++) {
            System.out.print(multiplos[i] + " ");
        }
    }
}
