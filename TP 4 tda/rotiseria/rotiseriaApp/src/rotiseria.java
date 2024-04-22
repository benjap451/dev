public class rotiseria {
    private int codigo;
    private String descripcion;
    private int[] costo = new int[10];
    private String direccion;
    private String nombre;
    private long telefono;

    // constructores
    public rotiseria(int codigo, String descripcion, int[] costo, String direccion, String nombre, long telefono) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public rotiseria(int codigo) {
        this.codigo = codigo;
    }

    // observadores
    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int[] getCosto() {
        return costo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    // modificadores
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(int[] costo) {
        this.costo = costo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    // pro tip
    public int calcularCosto(int[] costo) {
        int costoFinal = 0;
        for (int i = 0; i < costo.length; i++) {
            costoFinal += costo[i];
        }
        return costoFinal;
    }

    public String toString(rotiseria pedido) {
        int[] costo = pedido.getCosto();
        int costoFinal = calcularCosto(costo);
        return ("Codigo:" + codigo + ", Costo: " + costoFinal + ", Direccion: "
                + direccion + ", Nombre: " + nombre);
    }

}
