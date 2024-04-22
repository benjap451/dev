import java.util.Scanner;

public class app {
    // pro tip11

    public static void main(String[] args) {
        String nombre;
        int cod, edad;
        double peso;
        mascota otrMascota = new mascota(0, "", 0, 0);
        otrMascota = cargarMasc();
        System.out.println("los datos de la mascota son: " + otrMascota.toString());

    }

    public static mascota cargarMasc() {
        Scanner sc = new Scanner(System.in);
        mascota otrMascot = new mascota(0, "", 0, 0);
        int cod, edad;
        String nom;
        double peso;
        System.out.println("ingrese el codigo de la mascota: ");
        cod = sc.nextInt();
        System.out.println("ingrese nombre: ");
        nom = sc.next();
        System.out.println("ingrse peso: ");
        peso = sc.nextDouble();
        System.out.println("ingrese edad: ");
        edad = sc.nextInt();
        System.out.println(nom);
        otrMascot = new mascota(cod, nom, peso, edad);
        return otrMascot;
    }
}