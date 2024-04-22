import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        TDAviajante[][] matriz = new TDAviajante[5][12];
        TDAviajante unViajante = new TDAviajante("benja", "pastor", 21, "viajero", 10, 44324);
        int unMes = unViajante.getMes() - 1;
        System.out.println(inscribeViajante(matriz, unViajante, unMes));
    }

    public static boolean inscribeViajante(TDAviajante[][] matriz, TDAviajante unViajante, int unMes) {
        boolean bool = false, hayMes = false, hayAsiento = false;
        int i = 0;
        if (unMes > 0 && unMes <= 12) {
            hayMes = true;
        }
        while (hayAsiento == false) {
            if (matriz[i][unMes] == null) {
                hayAsiento = true;
            }
            if (hayAsiento) {
                matriz[i][unMes] = unViajante;
            }
            i++;
        }
        if (hayAsiento == true && hayMes == true) {
            bool = true;
        }
        return bool;
    }

    public static void mostrar(TDAviajante[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] != null) {
                    System.out.print("viajante ");
                } else {
                    System.out.print("null");
                }
            }
            System.out.println("");
        }
    }

    public static void matrizCompleta(TDAviajante[][] matriz) {
        Scanner teclado = new Scanner(System.in);
        int e, m, p = 1, cod;
        String n, a, c;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("viajero: " + p);
                p++;
                System.out.print("ingrese el nombre: ");
                n = teclado.next();
                System.out.print("ingrese el codigo: ");
                cod = teclado.nextInt();
                TDAviajante viajante = new TDAviajante(n, cod);
                matriz[i][j] = viajante;
            }
        }
    }

    public static boolean anotadoEnViaje(TDAviajante[][] matriz) {
        boolean esta = false;
        Scanner teclado = new Scanner(System.in);
        System.out.print("ingrese el codigo del viajante que busca: ");
        int cod = teclado.nextInt();
        String nom = "";
        int i = 0, j = 0;
        while (esta == false && i <= matriz.length - 1) {
            while (esta == false && j <= matriz[0].length - 1) {
                if (matriz[i][j] != null) {
                    if (cod == matriz[i][j].getCodigo()) {
                        esta = true;
                        nom = matriz[i][j].getNombre();
                    }
                }
                j++;
            }
            j = 0;
            i++;
        }
        if (esta) {
            System.out.println("el viajante " + nom + " esta en la matriz");
        } else {
            System.out.println("no esta ese viajante");
        }
        System.out.println("quiere probar otro codigo?: ");
        String otro = teclado.next();
        if (otro.equalsIgnoreCase("si"))
            anotadoEnViaje(matriz);
        return esta;
    }
}
