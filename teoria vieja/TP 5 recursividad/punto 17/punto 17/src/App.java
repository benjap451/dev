import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String pirad = " ";
        Scanner teclado = new Scanner(System.in);
        System.out.print("ingrese un numero: ");
        int n = teclado.nextInt(), i = 1;
        piramide(n, i, pirad);
    }

    public static String piramide(int n, int i, String pirad) {
        if (i == n + 1) {
            pirad = i + pirad;
        } else {
            pirad = i + pirad;
            System.out.println(pirad);
            piramide(n, i + 1, pirad);
        }
        return pirad;
    }
}
