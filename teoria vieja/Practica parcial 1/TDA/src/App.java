import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        String isbn;
        Scanner teclado =new Scanner(System.in);
        System.out.println("Ingrese su ISBN: ");
        isbn=teclado.nextLine();
        if (validar(isbn)==true){
            System.out.println("Su ISBN es correcta");
        } else {
            System.out.println("Su ISBN es incorrecta");
        }
    }

    public static boolean validar(String isbn){
        boolean bool=false;
        char a;
        int b, d=0,e=0, c;
        for (int i = 0; i < isbn.length()-1; i++) {
            if (i%2==0){
                a= isbn.charAt(i);
                b=a-'0';
                c=b*1;
            }
            else {
                a= isbn.charAt(i);
                b=a-'0';
                c=b*3;
            }
            d=d+c;
        }
        if (d%10==0){
            bool=true;
        }
        return bool;
    }
    
}
