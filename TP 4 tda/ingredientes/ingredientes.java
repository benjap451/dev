public class ingredientes {
    private String ingrediente;
    private double cant;
    private String unidad;

    // constructores

    public ingredientes(String ingrediente, double cant, String unidad) {
        this.ingrediente = ingrediente;
        this.cant = cant;
        this.unidad = unidad;
    }

    public ingredientes(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    // mod
    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    public void setCant(double cant) {
        this.cant = cant;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    // obs
    public String getIngrediente() {
        return ingrediente;
    }

    public double getCant() {
        return cant;
    }

    public String getUnidad() {
        return unidad;
    }

    public String toString() {
        return ("ingrediente: " + ingrediente + ", cantidad: " + cant + unidad);
    }
}
