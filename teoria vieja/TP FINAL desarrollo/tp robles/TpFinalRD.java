package tpfinalrd;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Robles Francisco
 */
public class TpFinalRD {

    public static String devuelvePosAlum(Alumnos[][] grados) {
        Scanner teclado = new Scanner(System.in);
        int legajo, i, j = 0;
        boolean encontrado = false;
        String msg = "El alumno no se ha encontrado";

        System.out.println("Ingrese el grado del alumno");
        i = teclado.nextInt();

        System.out.println("Ingrese el legajo del alumno");
        legajo = teclado.nextInt();

        while (j < grados[i].length && !encontrado) {
            if (grados[i-1][j] != null) {
                if (grados[i-1][j].getLegajo() == legajo) {
                    msg = "El alumno se encuentra en la posicion: " + (j + 1);
                    encontrado = true;
                } else {
                    j++;
                }
            } else {
                j = grados[i].length;
            }
        }
        return msg;
    }

    public static int vacantesTotales(Alumnos[][] grados, int i, int j, int ocupados) {
        int total = ocupados;

        if (i < grados.length) {
            if (j < grados[i].length) {
                if (grados[i][j] != null) {
                    total = vacantesTotales(grados, i, j + 1, ocupados + 1);
                } else {
                    total = vacantesTotales(grados, i, j + 1, ocupados);
                }
            } else {
                total = vacantesTotales(grados, i + 1, 0, ocupados);
            }
        }
        return total;
    }

    public static void mostrarEgresados(Alumnos[] egresados) {
        int i, j;
        Alumnos aux;
        for (i = 0; i < egresados.length; i++) {
            for (j = 0; j < egresados.length - i - 1; j++) {
                if (egresados[j + 1] != null) {
                    if (egresados[j].getPromedio() < egresados[j + 1].getPromedio()) {
                        aux = egresados[j];
                        egresados[j] = egresados[j + 1];
                        egresados[j + 1] = aux;
                    }
                }
            }
        }
        for (i = 0; i < egresados.length; i++) {
            if (egresados[i] != null) {
                System.out.println(egresados[i].toString());
            }
        }
    }

    public static void cargarGrado(Alumnos[][] grados, Alumnos[] auxAlumnos, int i) {
        int j = 0;
        while (j < grados[i].length && grados[i][j] != null) {
            auxAlumnos[j] = grados[i][j];
            j++;
        }
    }

    public static void ordenarAlumnosBm(Alumnos[] auxAlumnos) {
        int i, j;
        i = 0;
        Alumnos aux;
        boolean noOrdenado = false;
        while (i < auxAlumnos.length - 1 && !noOrdenado) {
            noOrdenado = true;
            for (j = 0; j < auxAlumnos.length - i - 1; j++) {
                if (auxAlumnos[j + 1] != null) {
                    if (auxAlumnos[j].getApellido().compareTo(auxAlumnos[j + 1].getApellido()) > 0) {
                        if (auxAlumnos[j].getNombre().compareTo(auxAlumnos[j + 1].getApellido()) > 0) {
                            noOrdenado = false;
                            aux = auxAlumnos[j];
                            auxAlumnos[j] = auxAlumnos[j + 1];
                            auxAlumnos[j + 1] = aux;
                        }
                    }
                } else {
                    noOrdenado = true;
                }
            }
        }
    }

    public static void mostrarAlum(Alumnos[][] grados) {
        Scanner teclado = new Scanner(System.in);
        int i, it;
        Alumnos[] auxAlumnos = new Alumnos[30];

        System.out.println("Ingrese que grado quiere ver");
        i = teclado.nextInt();

        cargarGrado(grados, auxAlumnos, i - 1);
        ordenarAlumnosBm(auxAlumnos);

        for (it = 0; it < auxAlumnos.length; it++) {
            if (auxAlumnos[it] != null) {
                System.out.println(auxAlumnos[it].getApellido() + ";" + auxAlumnos[it].getNombre());
            }
        }
    }

    public static double calculaProm(Alumnos[][] grados, int i, int j) {
        double promedio = 0;

        if (j < grados[i].length && grados[i][j] != null) {
            promedio = grados[i][j].getPromedio() + calculaProm(grados, i, j + 1);
        }
        return promedio;
    }

    public static Alumnos[][] aumentarGrado(Alumnos[][] grados, Alumnos[] egresados) {

        int i, j, itEgresados = 0;
        int[] desaprobados = new int[Alumnos.cantLegajos()];
        Alumnos.cargarDesaprobados(desaprobados);
        Alumnos[][] newGrado = new Alumnos[7][30];
        boolean noNulo, yaEgresaron = false;
        int g1 = 0, g2 = 0, g3 = 0, g4 = 0, g5 = 0, g6 = 0, g7 = 0;

        for (i = grados.length - 1; i >= 0; i--) {
            noNulo = true;
            j = 0;
            while (j < grados[i].length && noNulo) {
                if (grados[i][j] != null) {
                    if (!Alumnos.equals(grados[i][j], desaprobados)) {
                        if (grados[i][j].getPromedio() >= 6 && !yaEgresaron) {
                            egresados[itEgresados] = grados[i][j];
                            grados[i][j] = null;
                            itEgresados++;
                            j++;
                        } else {
                            if (grados[i][j].getPromedio() >= 6) {
                                switch (grados[i][j].getGrado()) {
                                    case 1:
                                        newGrado[1][g2] = grados[i][j];
                                        g2++;
                                        grados[i][j].setGrado(2);
                                        break;
                                    case 2:
                                        newGrado[2][g3] = grados[i][j];
                                        g3++;
                                        grados[i][j].setGrado(3);
                                        break;
                                    case 3:
                                        newGrado[3][g4] = grados[i][j];
                                        g4++;
                                        grados[i][j].setGrado(4);
                                        break;
                                    case 4:
                                        newGrado[4][g5] = grados[i][j];
                                        g5++;
                                        grados[i][j].setGrado(5);
                                        break;
                                    case 5:
                                        newGrado[5][g6] = grados[i][j];
                                        g6++;
                                        grados[i][j].setGrado(6);
                                        break;
                                    case 6:
                                        newGrado[6][g7] = grados[i][j];
                                        g7++;
                                        grados[i][j].setGrado(7);
                                        break;
                                }
                                j++;
                            } else {
                                j++;
                            }
                        }
                    } else {
                        switch (grados[i][j].getGrado()) {
                            case 1:
                                newGrado[0][g1] = grados[i][j];
                                g1++;
                                break;
                            case 2:
                                newGrado[1][g2] = grados[i][j];
                                g2++;
                                break;
                            case 3:
                                newGrado[2][g3] = grados[i][j];
                                g3++;
                                break;
                            case 4:
                                newGrado[3][g4] = grados[i][j];
                                g4++;
                                break;
                            case 5:
                                newGrado[4][g5] = grados[i][j];
                                g5++;
                                break;
                            case 6:
                                newGrado[5][g6] = grados[i][j];
                                g6++;
                                break;
                            case 7:
                                newGrado[6][g7] = grados[i][j];
                                g7++;
                                break;
                        }
                        j++;
                    }
                } else {
                    noNulo = false;
                    yaEgresaron = true;
                }
            }
        }
        return newGrado;
    }

    public static Alumnos crearAlumno(String alumno) {
        Alumnos unAlumno = new Alumnos("", "", 0, 0, 0);
        String[] separador = alumno.split(";");

        if (separador.length == 5) {
            String nombre = separador[0];
            String apellido = separador[1];
            int legajo = Integer.parseInt(separador[2]);
            int grado = Integer.parseInt(separador[3]);
            double promedio = Double.parseDouble(separador[4]);
            unAlumno = new Alumnos(apellido, nombre, legajo, grado, promedio);
        }

        return unAlumno;
    }

    public static void cargarAlumnos(Alumnos[][] grados) {

        String ListaAlumnos = "C:\\Users\\roble\\OneDrive\\Escritorio\\ListaAlumnos.txt";

        String linea;
        Alumnos unAlumno;
        int g1 = 0, g2 = 0, g3 = 0, g4 = 0, g5 = 0, g6 = 0, g7 = 0;

        try {

            FileReader lectorArchivo = new FileReader(ListaAlumnos);
            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);

            while ((linea = bufferLectura.readLine()) != null) {
                unAlumno = crearAlumno(linea);
                if (unAlumno.esValido() && !unAlumno.noRepite(grados)) {
                    switch (unAlumno.getGrado()) {
                        case 1:
                            grados[0][g1] = unAlumno;
                            g1++;
                            break;
                        case 2:
                            grados[1][g2] = unAlumno;
                            g2++;
                            break;
                        case 3:
                            grados[2][g3] = unAlumno;
                            g3++;
                            break;
                        case 4:
                            grados[3][g4] = unAlumno;
                            g4++;
                            break;
                        case 5:
                            grados[4][g5] = unAlumno;
                            g5++;
                            break;
                        case 6:
                            grados[5][g6] = unAlumno;
                            g6++;
                            break;
                        case 7:
                            grados[6][g7] = unAlumno;
                            g7++;
                            break;
                    }
                }
            }
            bufferLectura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "No existe el archivo");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }

    }

    public static int cantAlumnos(Alumnos[][] grados, int i) {
        int cantAlum = 0, j;
        j = 0;
        boolean corte = true;

        while (j < grados[i].length && corte) {
            if (grados[i][j] != null) {
                cantAlum++;
                j++;
            } else {
                corte = false;
            }
        }
        return cantAlum;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 1, i, cantAlum;

        Alumnos[][] grados = new Alumnos[7][30];
        Alumnos[] egresados = new Alumnos[30];

        while (opcion != 0) {
            System.out.println("");
            System.out.println("Ingrese que desea hacer");
            System.out.println("1. Cargar alumnos");
            System.out.println("2. Pasar alumnos de grado (Los repitentes se escribiran en un bloc de notas)");
            System.out.println("3. Calcular promedios generales de los grados");
            System.out.println("4. Mostrar alumnos de un grado");
            System.out.println("5. Mostrar alumnos egresados");
            System.out.println("6. Calcular vacantes del colegio");
            System.out.println("7. Mostrar la ubicacion de un alumno");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    cargarAlumnos(grados);
                    System.out.println("Alumnos cargados");
                    break;
                case 2:
                    grados = aumentarGrado(grados, egresados);
                    break;
                case 3:
                    for (i = 0; i < grados.length; i++) {
                        cantAlum = cantAlumnos(grados, i);
                        System.out.println("El grado " + (i + 1) + " tiene un promedio de: " + calculaProm(grados, i, 0) / cantAlum);
                    }
                    break;
                case 4:
                    mostrarAlum(grados);
                    break;
                case 5:
                    mostrarEgresados(egresados);
                    break;
                case 6:
                    System.out.println("Cantidad de vacantes: " + (30 * 7 - vacantesTotales(grados, 0, 0, 0)));
                    break;
                case 7:
                    System.out.println(devuelvePosAlum(grados));
            }
        }
    }
}