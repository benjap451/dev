import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner (System.in);
        int col;
        String[][] libreria= {
        {"libro", "libro", "libro", "libro", null, null}, 
        {"libro", "libro", "libro", null, null, null}, 
        {"libro", "libro", "libro", null, null, null}};
        mostrar(libreria);
        System.out.println(" ");
        System.out.println("Ingrese la fila: ");
        col= teclado.nextInt()-1;
        System.out.println(" ");
        System.out.println("La cantidad de ejemplares en la sala son: "+cantEj(libreria, col));
        System.out.println(" ");
        System.out.println("La cantidad de salas vacias son: "+ cantSalas(libreria));

        
    }

    public static void mostrar(String[][] libreria){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(libreria[i][j]+ " ");
            }
            System.out.println(" ");
        }
    }

    public static int cantEj (String[][] libreria, int col){
        int i=0, b=0;
        boolean bool=true;
        while (bool==true && b<3){
            if (libreria[b][col]!=null){
                i++;
            }
            else {
                bool=false;
            }
            b++;
        }
        return i;
    }

    public static int cantSalas(String [][] libreria){
        int i=0, j,k, a=0;
        for (k = 0; k < 6; k++) {
            for ( j = 0; j < 3; j++) {
                if (libreria[j][k]==null){
                    a++;
                }
            }
            if (a>=3){
                i++;
            }
        }
        return i;
    }
}
