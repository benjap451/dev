import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        rotiseria pedido;
        pedido = cargarPedido();
        mostrarPedido(pedido);
    }

    public static rotiseria cargarPedido() {
        Scanner teclado = new Scanner(System.in);
        rotiseria pedido = new rotiseria(0, null, null, null, null, 0);
        int codigo;
        long telefono;
        String descripcion, direccion, nombre;
        int[] costo = new int[10];
        System.out.println("ingrese codigo de pedido:");
        codigo = teclado.nextInt();
        teclado.nextLine();
        System.out.println("");
        System.out.println("---------------------------------------------");
        System.out.println("");
        System.out.println("ingrese la descripcion: ");
        descripcion = teclado.nextLine();
        System.out.println("");
        System.out.println("---------------------------------------------");
        System.out.println("");
        for (int i = 0; i < costo.length; i++) {
            System.out.println("ingrese los productos seleccionados:");
            costo[i] = teclado.nextInt();
        }
        teclado.nextLine();
        System.out.println("");
        System.out.println("---------------------------------------------");
        System.out.println("");
        System.out.println("ingrese la direccion de entrega:");
        direccion = teclado.nextLine();
        System.out.println("");
        System.out.println("---------------------------------------------");
        System.out.println("");
        System.out.println("ingrese nombre del cliente:");
        nombre = teclado.nextLine();
        System.out.println("");
        System.out.println("---------------------------------------------");
        System.out.println("");
        System.out.println("ingrese telefono del cliente:");
        telefono = teclado.nextLong();
        System.out.println("");
        System.out.println("---------------------------------------------");
        System.out.println("");
        pedido = new rotiseria(codigo, descripcion, costo, direccion, nombre, telefono);
        return pedido;
    }

    public static void mostrarPedido(rotiseria pedido) {
        System.out.println("El pedido generado es:");
        System.out.println(pedido.toString(pedido));
    }
}
