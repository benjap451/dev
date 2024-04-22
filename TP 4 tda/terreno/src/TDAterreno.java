public class TDAterreno {
    private int codigo;
    private double base;
    private double altura;
    private int manzana;

    public TDAterreno(int codigo, double base, double altura, int manzana) {
        this.codigo = codigo;
        this.base = base;
        this.altura = altura;
        this.manzana = manzana;
    }

    public TDAterreno(int codigo) {
        this.codigo = codigo;

    }

    // mod
    public void setBase(double bas) {
        this.base = bas;
    }

    public void setCodigo(int cod) {
        this.codigo = cod;
    }

    public void setAltura(double alt) {
        this.altura = alt;
    }

    // obs
    public double getAltura() {
        return altura;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getBase() {
        return base;
    }

    public int getManzana() {
        return manzana;
    }

    // toString re piola
    public String toString() {
        return ("Codigo: " + codigo + " Altura: " + altura + " Base: " + base + " Manzana: " + manzana + "");
    }

    // pro tip
    public boolean equals(TDAterreno unTerreno) {
        return this.codigo == unTerreno.getCodigo();
    }

    public double perimetro(double base, double altura) {
        double per = 0;
        per = 2 * base + 2 * altura;
        return per;
    }

    public double sup(double base, double altura) {
        double superf = 0;
        superf = base * altura;
        return superf;
    }
}