import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        String explosion = "";
        System.out.println("Ingrese un numero: ");
        int n = teclado.nextInt();
        System.out.println("ingrese la bomba: ");
        int b = teclado.nextInt();
        System.out.println(Mr_Bombastic2(n, b, explosion));
    }

    public static String Mr_Bombastic2(int n, int b, String explosion) {
        int n1 = n / b, n2 = n - (n / b);
        if (n1 <= b && n2 <= b) {
            explosion = n1 + "," + n2 + "";
        } else {
            if (b < n1 && n2 <= b) {
                n = n1;
                explosion = n2 + " " + Mr_Bombastic2(n, b, explosion) + ",";
            }
            if (b < n2 && n1 <= b) {
                n = n2;
                explosion = n1 + "," + Mr_Bombastic2(n, b, explosion) + "";
            }
            if (b < n2 && b < n1) {
                explosion = Mr_Bombastic2(n1, b, explosion) + "";
                explosion = explosion + "," + Mr_Bombastic2(n2, b, explosion) + "";
            }
        }
        return explosion;
    }
}
