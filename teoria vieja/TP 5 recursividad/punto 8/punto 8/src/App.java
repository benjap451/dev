import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese una palabra o frase: ");
        String cadena1 = teclado.nextLine();
        int i = cadena1.length() - 1;
        String invertida = "";
        boolean bool = palindromo(cadena1, i, invertida);
        if (bool == true) {
            System.out.println("la palabra o frase es palindromo");
        } else {
            System.out.println("la palabra o frase no es palindromo");
        }
    }

    public static boolean palindromo(String cadena1, int i, String invertida) {
        boolean sioNo = false;
        if (invertida.length() < cadena1.length()) {
            invertida = invertida + cadena1.charAt(i);
            System.out.println(i + " " + invertida.length() + " " + cadena1.length() + " " + invertida);
        }
        if (cadena1.equalsIgnoreCase(invertida) == false && i >= 0) {
            sioNo = palindromo(cadena1, i - 1, invertida);
        } else if (cadena1.equalsIgnoreCase(invertida)) {
            sioNo = true;
        }
        return sioNo;
    }
}
