
// int as = Integer.parseInt(sc.nextLine());
import java.util.Scanner;

public class app {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ing, unid;
        double cantidad;

        ingredientes nIngrediente = new ingredientes("", 0, "");
        System.out.println("ingrese el ingrediente: ");
        ing = sc.nextLine();
        System.out.println("ingrese la unidad de medida: (Unidad, L, gr) ");
        unid = sc.nextLine();
        System.out.println("ingrese la cantidad de " + unid);
        cantidad = sc.nextDouble();

        nIngrediente = new ingredientes(ing, cantidad, unid);
        System.out.println(nIngrediente.toString());
    }
}
