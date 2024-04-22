import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//trabajo ralizado por Benjamin Pastor

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        int grado, j = 0, opcion, cantAlumnos;
        TDAalumnos[] egresados = new TDAalumnos[500];

        // las siguientes lineas realizan la carga de los alumnos
        // en sus grados
        TDAalumnos[][] grados = new TDAalumnos[7][30];
        cargarAlumnos(grados);

        // carga de reprobados (los llame repitentes)
        int cantRepitentes = cantRepitentes();
        int[] repitentes = new int[cantRepitentes];
        cargarRepitentes(repitentes);

        // carga de ingresantes
        int cantIngresos = cantIngresantes();
        TDAalumnos[] ingresantes = new TDAalumnos[cantIngresos];
        cargarIngresantes(ingresantes);
        while (opcion != 0) {
            System.out.println("Elija la opcion a realizar:");
            System.out.println("1. Pasar alumnos de grado");
            System.out.println("2. Calcular promedios generales de los grados");
            System.out.println("3. Mostrar alumnos de un grado");
            System.out.println("4. Mostrar alumnos egresados");
            System.out.println("5. Calcular vacantes del colegio");
            System.out.println("6. Mostrar la ubicacion de un alumno");
            System.out.println("7. Realizar la busqueda de un alumno");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    grados = aumentarGrado(grados, egresados);
                    break;
                case 2:
                    for (i = 0; i < grados.length; i++) {
                        cantAlumnos = contarAlumnos(grados, i);
                        System.out.println("El grado " + (i + 1) + " tiene un promedio de: "
                                + calculaProm(grados, i, 0) / cantAlumnos);
                    }
                    break;
                case 3:
                    mostrarAlum(grados);
                    break;
                case 4:
                    mostrarEgresados(egresados);
                    break;
                case 5:
                    System.out.println("Cantidad de vacantes: " + (30 * 7 - vacantesTotales(grados, 0, 0, 0)));
                    break;
                case 6:
                    System.out.println(devuelvePosAlum(grados));
                    break;
                case 7:
                    System.out.println(buscarAlumno(grados));
                    break;
            }
        }
    }

    // este modulo muestra la matriz cargada de los alumnos en sus grados
    // respectivos
    public static void mostrarMatriz(TDAalumnos[][] grados) {
        for (int i = 0; i < grados.length; i++) {
            System.out.print("grado" + (i + 1) + ": ");
            for (int j = 0; j < grados[0].length; j++) {
                TDAalumnos alumno = grados[i][j];
                if (grados[i][j] != null) {
                    System.out.print(alumno.getLegajo() + ",");
                } else {
                    System.out.print("vacio, ");
                }
            }
            System.out.println("");
        }
    }

    // este modulo genera unAlumno y retorna para cargarlo despues
    public static TDAalumnos crearAlumno(String alumno) {
        TDAalumnos unAlumno = new TDAalumnos("", "", 0, 0, 0);
        String[] armarAlumno = alumno.split(";");
        if (armarAlumno.length == 5) {
            String apellido = armarAlumno[0];
            String nombre = armarAlumno[1];
            int legajo = Integer.parseInt(armarAlumno[2]);
            int grado = Integer.parseInt(armarAlumno[3]);
            double promedio = Double.parseDouble(armarAlumno[4]);
            unAlumno = new TDAalumnos(apellido, nombre, legajo, grado, promedio);
        }
        return unAlumno;
    }

    // este modulo realiza la carga en la matriz del alumno creado con "crearAlumno"
    public static void cargarAlumnos(TDAalumnos[][] grados) {
        String ListaIngresantes = "C:\\Users\\Benjamin\\Desktop\\ListaIngresantes.txt";
        String linea;
        TDAalumnos unalumno;
        try {
            FileReader lectorArchivo = new FileReader(ListaIngresantes);
            BufferedReader bufferLector = new BufferedReader(lectorArchivo);
            while ((linea = bufferLector.readLine()) != null) {
                unalumno = crearAlumno(linea);
                if (unalumno.getGrado() >= 1 && unalumno.getGrado() <= 7) {
                    int grado = unalumno.getGrado() - 1;
                    boolean alumnoCargado = false;
                    for (int j = 0; j < 30 && alumnoCargado == false; j++) {
                        if (grados[grado][j] == null) {
                            grados[grado][j] = unalumno;
                            alumnoCargado = true;
                        }
                    }
                }

            }
            bufferLector.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "No se encontro el archivo");
        } catch (IOException ex) {
            System.err.println("Error en lectura o escritura");
        }
    }

    // este modulo calcula la cantidad de repitentes (reprobados)
    // para asi poder definir un arreglo de repitentes de la longitud necesaria
    public static int cantRepitentes() {
        int contador = 0;
        String linea;
        String ListaDesaprobados = "C:\\Users\\Benjamin\\Desktop\\ListaDesaprobados.txt";
        try {
            FileReader lectorArchivo = new FileReader(ListaDesaprobados);
            BufferedReader bufferLector = new BufferedReader(lectorArchivo);
            while ((linea = bufferLector.readLine()) != null) {
                contador++;
            }
            bufferLector.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "No existe el archivo.");
        } catch (IOException ex) {
            System.err.println("Error escribiendo o leyendo el archivo.");
        }
        return contador;
    }

    // este modulo hace la carga de los legajos de los repitentes a su arreglo
    public static void cargarRepitentes(int[] repitentes) {
        int i = 0, legajo;
        String linea;
        String ListaDesaprobados = "C:\\Users\\Benjamin\\Desktop\\ListaDesaprobados.txt";
        try {
            FileReader lectorArchivo = new FileReader(ListaDesaprobados);
            BufferedReader bufferLector = new BufferedReader(lectorArchivo);
            while ((linea = bufferLector.readLine()) != null && i < repitentes.length) {
                legajo = Integer.parseInt(linea);
                repitentes[i] = legajo;
                i++;
            }
            bufferLector.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "No existe el archivo.");
        } catch (IOException ex) {
            System.err.println("Error escribiendo o leyendo el archivo.");
        }
    }

    // este modulo calcula la cantidad de ingresantes para definir el largo del
    // arreglo de ingresantes
    public static int cantIngresantes() {
        int contador = 0;
        String linea;
        String ListaIngresantes = "C:\\Users\\Benjamin\\Desktop\\ListaIngresantes.txt";
        try {
            FileReader lectorArchivo = new FileReader(ListaIngresantes);
            BufferedReader bufferLector = new BufferedReader(lectorArchivo);
            while ((linea = bufferLector.readLine()) != null) {
                contador++;
            }
            bufferLector.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "No existe el archivo.");
        } catch (IOException ex) {
            System.err.println("Error escribiendo o leyendo el archivo.");
        }
        return contador;
    }

    // este modulo realiza la carga de los ingresantes
    public static void cargarIngresantes(TDAalumnos[] ingresantes) {
        String ListaIngresantes = "C:\\Users\\Benjamin\\Desktop\\ListaIngresantes.txt";
        String linea;
        TDAalumnos unalumno;
        int i = 0;
        try {
            FileReader lectorArchivo = new FileReader(ListaIngresantes);
            BufferedReader bufferLector = new BufferedReader(lectorArchivo);
            while ((linea = bufferLector.readLine()) != null) {
                unalumno = crearAlumno(linea);
                boolean alumnoCargado = false;
                for (int j = 0; j < 30 && alumnoCargado == false; j++) {
                    if (ingresantes[i] == null) {
                        ingresantes[i] = unalumno;
                        alumnoCargado = true;
                    }
                }

            }
            bufferLector.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "No se encontro el archivo");
        } catch (IOException ex) {
            System.err.println("Error en lectura o escritura");
        }
    }

    // este modulo calcula de forma recursiva el promedio de cada grado
    public static double calcularPromedio(TDAalumnos[][] grados, int i, int j) {
        double prom = 0;
        TDAalumnos alumno;
        if (j == grados[i].length - 1 || grados[i][j + 1] == null) {
            alumno = grados[i][j];
            prom = alumno.getPromedio();
        } else {
            alumno = grados[i][j];
            prom = alumno.getPromedio() + calcularPromedio(grados, i, j + 1);
        }
        return prom;
    }

    // este modulo cuenta la cantidad de vacantes
    public static int cantidadLugares(TDAalumnos[][] grados, int i, int j, int ocupados) {
        int vacantes = ocupados, suma = 0;
        if (i < grados.length) {
            if (j < grados[0].length && grados[i][j] != null) {
                vacantes = cantidadLugares(grados, i, j + 1, ocupados + 1);
            } else {
                vacantes = cantidadLugares(grados, i + 1, 0, ocupados);
            }
        }
        return grados.length * grados[0].length - vacantes;
    }

    // este modulo realiza el alta del nuevo alumno pidiendo los datos al usuario
    public static void nuevoAlumno(TDAalumnos[][] grados) {
        Scanner teclado = new Scanner(System.in);
        int i, j = 0;
        boolean ingresado = false;
        String alumno, nombre, apellido, legajo, grado, promedio;
        System.out.print("ingrese el apellido: ");
        apellido = teclado.nextLine();
        System.out.print("Ingrese el nombre: ");
        nombre = teclado.nextLine();
        System.out.print("ingresse el legajo: ");
        legajo = teclado.nextLine();
        System.out.print("Ingrese el grado: ");
        grado = teclado.nextLine();
        System.out.print("Ingrese el  promedio: ");
        promedio = teclado.nextLine();
        alumno = apellido + ";" + nombre + ";" + legajo + ";" + grado + ";" + promedio;
        i = Integer.parseInt(grado) - 1;
        TDAalumnos unAlumno = crearAlumno(alumno);
        while (i <= grados.length - 1 && j < grados[0].length && ingresado == false) {
            if (grados[i][j] == null) {
                grados[i][j] = unAlumno;
                ingresado = true;
                System.out.println("El alumno se cargo correctamente");
            } else {
                j++;
            }
        }
    }

    // este modulo realiza la busqueda de un alummno
    public static String buscarAlumno(TDAalumnos[][] grados) {
        Scanner teclado = new Scanner(System.in);
        TDAalumnos unAlumno;
        String posicion = "";
        int legajo, grado, j = 0;
        boolean encontrado = false;
        System.out.println("Ingrese el legajo que busca: ");
        legajo = teclado.nextInt();
        System.out.print("Ingrese el grado donde lo busca: ");
        grado = teclado.nextInt();

        while (encontrado == false && j < grados[0].length) {
            unAlumno = grados[grado - 1][j];
            System.out.println(legajo + ", " + unAlumno.getLegajo());
            if (unAlumno != null && legajo == unAlumno.getLegajo()) {
                encontrado = true;
                j = j + 1;
                posicion = "grado: " + grado + " columna: " + j;
            }
            j++;
        }
        if (!encontrado) {
            posicion = "El legajo no se encuentra en ese grado";
        }
        return posicion;
    }

    // este modulo es de uso auxiliar para contar cuantos alumnos hay por grado
    public static int contarAlumnos(TDAalumnos[][] grados, int i) {
        int cantidad = 0, j = 0;
        boolean esNulo = false;
        while (j < grados[i].length && esNulo == false) {
            if (grados[i][j] != null) {
                cantidad++;
            } else {
                esNulo = true;
            }
            j++;
        }
        return cantidad;
    }

    // este modulo realiza el aumento de grado
    public static TDAalumnos[][] aumentarDeGrado(TDAalumnos[][] grados, int[] repitentes, TDAalumnos[] ingresantes,
            TDAalumnos[] egresados) {
        TDAalumnos[][] nuevosGrados = new TDAalumnos[7][30];
        int i = grados.length, j = 0;

        return nuevosGrados;
    }

    public static boolean esRepitente(int[] repitentes, TDAalumnos unAlumno) {
        boolean repite = false;
        int legajo = unAlumno.getLegajo(), i = 0;
        while (i < repitentes.length && repite == false) {
            if (legajo == repitentes[i]) {
                repite = true;
            }
            i++;
        }
        return repite;
    }

    // este modulo carga los egresados
    public static TDAalumnos[] cargarEgresados(TDAalumnos[][] grados, TDAalumnos[] egresados, int[] repitentes) {
        int j = 0, i = 0, maxGrado = grados.length - 1;
        boolean esNulo = false, repite = false;
        TDAalumnos unAlumno;
        while (i < grados[0].length && esNulo == false) {
            unAlumno = grados[maxGrado][i];
            repite = esRepitente(repitentes, unAlumno);
            boolean cargado = false;
            while (j < egresados.length && repite == false && cargado == false)
                if (egresados[j] == null) {
                    egresados[j] = unAlumno;
                    cargado = true;
                } else {
                    j++;
                }
            i++;
            j = 0;
        }

        return egresados;
    }
}
