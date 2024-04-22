import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        float[] notas = new float[9];
        float nota = 0;
        notas = carga(nota);
        boolean bool;
        bool = evaluar(notas);
        if (bool == true) {
            System.out.println("el alumno aprobo");
        } else {
            System.out.println("el alumno es re boludo");
        }

    }

    public static float[] carga(float nota) {
        float[] arreglo = new float[10];
        Scanner teclado = new Scanner(System.in);
        int i = 0, j = arreglo.length;
        for (i = 0; i < j; i++) {
            int p = i + 1;
            System.out.println("inregese la nota" + p + " del alumno:");
            nota = teclado.nextFloat();
            arreglo[i] = nota;
        }
        return arreglo;
    }

    public static boolean evaluar(float[] notas) {
        boolean bool = true;
        int i = 0, j = notas.length;
        while (i < j && bool == true) {
            if (notas[i] < 6) {
                bool = false;
            }
            i++;
        }
        return bool;
    }
}
