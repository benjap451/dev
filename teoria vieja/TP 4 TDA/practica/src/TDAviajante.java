public class TDAviajante {
    private String nombre;
    private String apellido;
    private int edad;
    private String clase;
    private int mes;
    private int codigo;

    // constructor
    public TDAviajante(String n, String a, int e, String c, int m, int cod) {
        this.nombre = n;
        this.apellido = a;
        this.edad = e;
        this.clase = c;
        this.mes = m;
        this.codigo = cod;
    }

    public TDAviajante(String n, int cod) {
        this.nombre = n;
        this.codigo = cod;
    }

    // observadores
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getClase() {
        return clase;
    }

    public int getMes() {
        return mes;
    }

    public int getCodigo() {
        return codigo;
    }

}