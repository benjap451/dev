import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        double base, altura;
        int manzana, codigo;
        Scanner teclado= new Scanner(System.in);
        System.out.println("ingrese la base de su terreno: ");
        base= teclado.nextDouble();
        System.out.println("ingrese la altura de su terreno: ");
        altura= teclado.nextDouble();
        System.out.println("ingrese la manzana: ");
        manzana = teclado.nextInt();
        System.out.println("ingrese el codigo de su terreno: ");
        codigo= teclado.nextInt();
        App terreno=new App(codigo, manzana, base, altura);
    }
}
