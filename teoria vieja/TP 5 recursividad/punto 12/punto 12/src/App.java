import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        char[] array = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
        int i = 0;
        char a;
        System.out.println("ingrese un caracter: ");
        a = teclado.next().charAt(0);
        System.out.println(esta(array, i, a));
    }

    public static boolean esta(char[] array, int i, char a) {
        boolean bool = false;
        if (i <= array.length - 1 && array[i] == a) {
            bool = true;
        } else if (i <= array.length - 1) {
            esta(array, i + 1, a);
        }
        return bool;
    }
}
