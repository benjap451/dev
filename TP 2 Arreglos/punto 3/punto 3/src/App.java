import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("ingrese un numero");
        int n;
        Scanner teclado = new Scanner(System.in);
        n = teclado.nextInt();
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (i % 2 == 0) {
                    System.out.print(cambio(i));
                } else {
                    System.out.print(i);
                }
            }
            System.out.println(" ");
        }
    }

    public static char cambio(int i) {
        char a = ' ';
        switch (i) {
            case 2:
                a = 'B';
                break;
            case 4:
                a = 'D';
                break;
        }
        return a;
    }
}
