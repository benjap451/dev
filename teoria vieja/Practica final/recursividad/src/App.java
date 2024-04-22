import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int i = 0;
        System.out.println("ingrese un numero: ");
        String num = teclado.nextLine();
        if (verificar(num, i)) {
            System.out.println("todos los digitos son iguales");
        } else {
            System.out.println("no son todos iguales");
        }
    }

    public static boolean verificar(String num, int i) {
        boolean bool = true;
        int largo = num.length();
        if (i <= largo - 1 && i + 1 < largo) {
            if (num.charAt(i) != num.charAt(i + 1)) {
                bool = false;
            } else {
                num = num.substring(i + 1, largo - 1);
                bool = verificar(num, i + 1);
            }
        }
        return bool;
    }
}
