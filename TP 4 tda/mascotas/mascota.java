public class mascota {
    private int codigo;
    private String nombre;
    private double peso;
    private int edad;

    // constructores
    public mascota (int codigo, String nombre, double peso, int edad){
        this.codigo=codigo;
        this.nombre=nombre;
        this.edad=edad;
        this.peso=peso;
    }
    public mascota(int codigo){
        this.codigo=codigo;
    }
    // obs
    public int getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public double getPeso(){
        return peso;
    }
    public int getEdad(){
        return edad;
    }
    //toString re piola

    public String toString(){
        return ("codigo: "+codigo+" nombre: "+nombre+" peso: "+peso+" edad: "+edad);
    }

    //mod
    public void setCodigo(int cod){
        this.codigo=cod;
    }
    public void setNombre(String nom){
        this.nombre=nom;
    }
    public void setPeso(double pes){
        this.peso=pes;
    }
    public void setEdad(int ed){
        this.edad=ed;
    }
    //pro tip
    public boolean equals (mascota otraMascota){
        return this.codigo==otraMascota.getCodigo();
    }
}
