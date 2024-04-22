import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        String contraseña;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese su contraseña: ");
        contraseña= teclado.nextLine();
        if (cantNum(contraseña)==true && isNum(contraseña)==true && isletra(contraseña)==true && isSimbolo(contraseña)==true){
            System.out.println("su contraseña es fuerte");
        }
        else {
            System.out.println("su contraseña no es suficientemente fuerte");
        }
    }         
    public static Boolean cantNum(String contraseña){
        boolean bool;
        int i=0;

        if (contraseña.length()>=8){
            i++;
        }
        if (i>=1){
            bool=true;
        }
        else {
            bool=false;
        }
        return bool;
    }

    public static boolean isNum(String contraseña){
        boolean bool1=true;
        int i=0, n=0;
        for (i=0; i<=contraseña.length()-1; i++){
            if (Character.isDigit(contraseña.charAt(i))){
                n++;
            }
        }
        if (n>=1){
            bool1=true;
        }
        else {
            bool1=false;
        }
        return bool1;
    } 
    public static boolean isletra(String contraseña){
        boolean bool2=true;
        int i, n=0;
        for (i=0; i<=contraseña.length()-1; i++){
            if (Character.isLetter(contraseña.charAt(i))){
                n++;
            }
        }
        if (n>=1){
            bool2=true;
        }
        else {
            bool2=false;
        }
        return bool2;
    }
    public static boolean isSimbolo(String contraseña){
        boolean bool3=true;
        int i, n=0;
        char a;
        for (i=0; i<=contraseña.length()-1; i++){
            a= contraseña.charAt(i);
            if (a=='%' || a=='$' || a=='*' || a=='#' || a=='/' || a=='-'){
                n++;
            }
        }
        if (n>=1){
            bool3=true;
        }
        else {
            bool3=false;
        }
        return bool3;
    }
}