import java.util.Scanner;

public class fecha {

    private int dia;
    private int mes;
    private int año;

    public fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    // mod
    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAño(int año) {
        this.año = año;
    }

    // obs
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    // toString re piola
    public String toString() {
        return ("Dia: " + dia + " mes: " + mes + " año: " + año);
    }

    // pro tip (propios del tipo)
    public boolean esBisiesto(int año) {
        boolean b1 = false;
        if ((año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0))) {
            b1 = true;
        }
        return b1;
    }

    public int diasTranscurridos(int dia, int mes, int año) {
        int dias = dia;
        boolean bisiesto = esBisiesto(año);
        int[] meses = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (bisiesto == true) {
            meses[1] = 29;
        }
        if (mes != 1) {
            for (int i = 0; i < mes - 1; i++) {
                dias = dias + meses[i];
            }
        }
        return dias;
    }

    public boolean esAnterior(int dia, int mes, int año) {
        Scanner sc = new Scanner(System.in);
        int dia2, mes2, año2, dias2;
        int diasTotal = diasTranscurridos(dia, mes, año);
        boolean b1 = false;
        System.out.println("ingrese una nueva fecha");
        System.out.println("dia: ");
        dia2 = sc.nextInt();
        System.out.println("mes: ");
        mes2 = sc.nextInt();
        System.out.println("año: ");
        año2 = sc.nextInt();
        dias2 = diasTranscurridos(dia2, mes2, año2);
        if (año == año2) {
            if (diasTotal <= dias2) {
                b1 = true;
            }
        } else if (año < año2) {
            b1 = true;
        }
        return b1;
    }

    public fecha calculaFecha(int dias) {
        Scanner sc = new Scanner(System.in);
        int cantDias, dia = this.dia, mes = this.mes, año = this.año;
        fecha nuevFecha;
        boolean bisiesto = esBisiesto(año);
        int[] meses = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (bisiesto == true) {
            meses[1] = 29;
        }
        cantDias = diasTranscurridos(dia, mes, año);
        cantDias = dia + dias;
        while (cantDias > meses[mes - 1]) {
            cantDias -= meses[mes - 1];
            mes++;
            if (mes > 12) {
                mes = 1;
                año++;
            }
            bisiesto = esBisiesto(año);
            if (bisiesto == true) {
                meses[1] = 29;
            } else {
                meses[1] = 28;
            }
        }
        nuevFecha = new fecha(cantDias, mes, año);
        return nuevFecha;
    }
}
