package TDA2023;
//TDA especie animal

public class Especie {
 private String nombre;
 private int poblacion;
 private double tasaCrecimiento; // es el promedio anual y está en punto decimal

// Constructoras
public Especie(String nom){
    nombre=nom;
    poblacion=0;
    tasaCrecimiento=0.0;
}
public Especie(String n, int p, double t){
    nombre=n;
    poblacion=p;
    tasaCrecimiento=t;
}
//Observadoras
public String getNombre(){
    return nombre;
}
public int getPoblacion(){
    return poblacion;
}
public double getTasaCrecimiento(){
    return this.tasaCrecimiento;
}
 @Override
 public String toString (){
    return ("nombre: "+ nombre+", poblacion: "+ poblacion + ", tasa crec: "+tasaCrecimiento);
}
//Modificadoras

//no hay setNombre(..)
public void setPoblacion(int p){
    poblacion=p;
}
public void setTasaCrecimiento(double t){
    this.tasaCrecimiento=t;
}
//Comparadoras
public boolean equals(Especie e){
    return nombre.equalsIgnoreCase(e.getNombre());
}
//no puede haber dos equals
/*
 public boolean equals(Especie e){
    return nombre.compareTo(e.getNombre());
}
*/

}// Fin de la Clase
