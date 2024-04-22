package tpfinalrd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Robles Francisco
 */
public class Alumnos {

    private String apellido;
    private String nombre;
    private int grado;
    private int legajo;
    private double promedio;

    public Alumnos(String apellido, String nombre, int legajo, int grado, double promedio) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.grado = grado;
        this.promedio = promedio;
        this.legajo = legajo;
    }

    public double getPromedio() {
        return promedio;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getGrado() {
        return grado;
    }

    public String toString() {
        return (apellido + ";" + nombre + ";" + promedio + ";" + legajo);
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    private static boolean verificaCompuesto(String alumno) {
        boolean valido = true;
        int i = 0;

        while (i < alumno.length() && valido) {
            if (alumno.charAt(i) < 97 && alumno.charAt(i) > 122) {
                valido = false;
            } else {
                i++;
            }
        }
        return valido;
    }

    public boolean esValido() {
        boolean valido = false;
        if (verificaCompuesto(nombre.toLowerCase()) && verificaCompuesto(apellido.toLowerCase()) && promedio >= 0) {
            valido = true;
        }
        return valido;
    }

    public boolean noRepite(Alumnos[][] grados) {
        int i = 0, j;
        boolean seRepite = false, nulo;

        while (i < grados.length && !seRepite) {
            nulo = true;
            j = 0;
            while (j < grados[i].length && !seRepite && nulo) {
                if (grados[i][j] != null) {
                    if (grados[i][j].legajo == this.legajo) {
                        seRepite = true;
                    } else {
                        j++;
                    }
                } else {
                    nulo = false;
                }
            }
            i++;
        }
        return seRepite;
    }

    public static int cantLegajos() {
        String ListaDesaprobados = "C:\\Users\\roble\\OneDrive\\Escritorio\\ListaDesaprobados.txt";
        int contador = 0;
        String lista;
        try {
            FileReader lectorArchivo = new FileReader(ListaDesaprobados);
            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);

            while ((lista = bufferLectura.readLine()) != null) {
                contador++;
            }
            bufferLectura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "No existe el archivo");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
        return contador;
    }

    public static void cargarDesaprobados(int[] desaprobados) {

        String linea;
        int legajo, i;
        String ListaDesaprobados = "C:\\Users\\roble\\OneDrive\\Escritorio\\ListaDesaprobados.txt";

        try {
            FileReader lectorArchivo = new FileReader(ListaDesaprobados);
            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            i = 0;
            while ((linea = bufferLectura.readLine()) != null && i < desaprobados.length) {
                legajo = Integer.parseInt(linea);
                desaprobados[i] = legajo;
                i++;
            }
            bufferLectura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "No existe el archivo");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }

    public static boolean equals(Alumnos unAlumno, int[] desaprobados) {
        int i = 0;
        boolean igual = false;

        if (desaprobados != null) {
            while (i < desaprobados.length && !igual) {
                if (unAlumno.legajo == desaprobados[i]) {
                    igual = true;
                } else {
                    i++;
                }
            }
        }
        return igual;
    }

}
