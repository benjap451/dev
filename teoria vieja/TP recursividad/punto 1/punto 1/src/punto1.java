import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int i = 0, n = 0, num;
        System.out.println("ingrese su numero: ");
        num = teclado.nextInt();
        boolean bool = evaluar(num);
        System.out.println(bool);
    }

    public static boolean evaluar(int num) {
        boolean bool = false;
        int i = num % 10;
        int n = (num / 10) % 10;
        System.out.println("i= " + i + " n= " + n + " num= " + num);
        if (i == 0 && n == 9) {
            bool = true;
        } else {
            if (n == i - 1) {
                bool = true;
            } else if (num >= 10) {
                num = num / 10;
                bool = evaluar(num);
            }
        }

        return bool;
    }
}
