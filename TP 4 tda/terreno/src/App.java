import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, World!");
        double base, altura, valTerr;
        TDAterreno unTerreno = new TDAterreno(0, 0, 0, 0);
        unTerreno = cargarTerreno(unTerreno);
        System.out.println("ingrese el valor por metro cuadrado desea poner al terreno: ");
        valTerr = sc.nextDouble();
        base = unTerreno.getBase();
        altura = unTerreno.getAltura();
        System.out.println("la cant de alambre a utilizar son: " + 3 * unTerreno.perimetro(base, altura));
        System.out.println("el valor de la limpieza es: " + 150 * unTerreno.sup(base, altura));
        System.out.println("el valor final del terreno es: " + valTerr * unTerreno.sup(base, altura));

    }

    public static TDAterreno cargarTerreno(TDAterreno unTerreno) {
        Scanner sc = new Scanner(System.in);
        TDAterreno nuevoTerr = new TDAterreno(0, 0, 0, 0);
        int num, manzana;
        double base, altura;
        System.out.println("ingrese codigo:");
        num = sc.nextInt();
        sc.nextLine();
        System.out.println("ingrese base:");
        base = sc.nextDouble();
        System.out.println("ingrese altura:");
        altura = sc.nextDouble();
        System.out.println("ingrese manzana:");
        manzana = sc.nextInt();
        nuevoTerr = new TDAterreno(num, base, altura, manzana);
        return nuevoTerr;
    }
}
