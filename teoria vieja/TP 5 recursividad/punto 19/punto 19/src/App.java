import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String pirad = " ", para2 = "";
        Scanner teclado = new Scanner(System.in);
        System.out.print("ingrese un numero: ");
        int n = teclado.nextInt(), i = 1;
        piramide(n, i, pirad, para2);
    }

    public static String piramide(int n, int i, String pirad, String para2) {
        int a = i - 1;
        if (i == n + 1) {
            pirad = i + pirad;
        } else {
            pirad = i + pirad;
            para2 = a + pirad;
            System.out.println(para2);
            piramide(n, i + 1, pirad, para2);
        }
        return pirad;
    }

    public static String vacio(int n, int i, String para2) {
        if (i == n + 1) {
            para2 = para2 + i;
        } else {
            para2 = para2 + i;
            System.out.println(para2);
            piramide(n, i + 1, para2);
        }
        return para2;
    }
}