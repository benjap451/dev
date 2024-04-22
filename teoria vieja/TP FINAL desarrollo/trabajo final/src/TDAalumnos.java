public class TDAalumnos {
    private String apellido;
    private String nombre;
    private int legajo;
    private int grado;
    private double promedio;

    // constructor
    public TDAalumnos(String a, String n, int l, int g, double p) {
        this.apellido = a;
        this.nombre = n;
        this.legajo = l;
        this.grado = g;
        this.promedio = p;
    }

    // observadores
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public int getGrado() {
        return grado;
    }

    public double getPromedio() {
        return promedio;
    }

    // modificadores
    public void setGrado(int g) {
        grado = g;
    }

    // toString re piola
    public String toString() {
        return ("apellido: " + apellido + ", nombre: " + nombre + ", legajo: " + legajo + ", grado: " + grado
                + ", promedio: " + promedio);
    }
}
