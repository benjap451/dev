public class tdaTerreno {
    private int codigo;
    private int manzana;
    private double base;
    private double altura;

    //constructores
    public tdaTerreno (int unCodigo){
        this.codigo=unCodigo;
    }

    public tdaTerreno (int cod, int man, double bas, double alt){
        this.codigo=cod;
        this.manzana=man;
        this.base=bas;
        this.altura=alt;
    }

    //observadores
    public int getCodigo(){
        return codigo;
    }
    public int getManzana(){
        return manzana;
    }
    public double getBase(){
        return base;
    }
    public double getAltura(){
        return altura;
    }
    public String toString(){
        return ("codigo: "+codigo+", manzana: "+manzana+", base: "+base+", altura: "+altura);
    }
    public boolean equals(tdaTerreno ter){
        return codigo==ter.getCodigo();
    }

    //modificadores

}






