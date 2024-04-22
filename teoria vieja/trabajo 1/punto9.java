import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int largo=0,i;
        String frase, comparar=" ", pFinal="", palabraLarga="";
        Scanner teclado= new Scanner(System.in);
        System.out.print("Ingrese su frase: ");
        frase=  teclado.nextLine();
        largo = frase.length();
        for (i=0; i<frase.length(); i++){
            if (Character.isLetter(frase.charAt(i))){
                pFinal= pFinal+frase.charAt(i);
                if (pFinal.length()>palabraLarga.length()){
                    palabraLarga=pFinal;
                    largo=palabraLarga.length();
                }
            }
            else if (Character.isWhitespace(frase.charAt(i))){
                pFinal="";
            }
        }
        System.out.println("su palabra mas larga es: "+ palabraLarga +" con "+ largo + " caracteres");
    }
}
