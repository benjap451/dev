import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean b1 = false, b2;
        int dias, dia, mes, año;
        fecha nuevaFecha, fecha2;

        // creacion de la clase
        nuevaFecha = crearFecha();
        System.out.println("------------------------------------------");

        // verificacion si el año es biciesto
        b1 = nuevaFecha.esBisiesto(nuevaFecha.getAño());
        System.out.println(nuevaFecha.toString());
        System.out.println("------------------------------------------");
        dia = nuevaFecha.getDia();
        mes = nuevaFecha.getMes();
        año = nuevaFecha.getAño();

        // calculo de los dias transcurridos
        dias = nuevaFecha.diasTranscurridos(dia, mes, año);
        System.out.println("la cantidad de dias son: " + dias + " es bisiesto: " + b1);
        System.out.println("------------------------------------------");

        // calcula si una fecha es anterior a la guardada
        b1 = nuevaFecha.esAnterior(dia, mes, año);
        System.out.println("la fecha guardada es anterior? " + b1);
        System.out.println("------------------------------------------");

        // calcula una nueva fecha
        System.out.println("ingrese la cantidad de dias:");
        dias = sc.nextInt();
        fecha2 = nuevaFecha.calculaFecha(dias);
        System.out.println("nueva fecha:");
        System.out.println("dia: " + fecha2.getDia() + " mes: " + fecha2.getMes() + " año: " + fecha2.getAño());
    }

    public static fecha crearFecha() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("pastilla");
        int dia, mes, año;
        fecha nuevaFecha;
        boolean b1 = true;
        do {
            System.out.println("ingrese el dia:");
            dia = teclado.nextInt();
            System.out.println("ingrese el mes:");
            mes = teclado.nextInt();
            System.out.println("ingrese el año:");
            año = teclado.nextInt();
            nuevaFecha = new fecha(dia, mes, año);
            b1 = fechaValida(nuevaFecha, dia, mes, año);
            if (b1 == false) {
                System.out.println("fecha invalida, ingrese otra...");
            }
        } while (b1 == false);
        return nuevaFecha;
    }

    public static boolean fechaValida(fecha nuevaFecha, int dia, int mes, int año) {
        boolean b1 = true, bisiesto = nuevaFecha.esBisiesto(año);
        int[] meses = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (bisiesto == true) {
            meses[1] = 29;
        }
        if (dia > meses[mes - 1]) {
            b1 = false;
        }
        return b1;
    }
}