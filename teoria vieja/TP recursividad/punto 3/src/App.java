public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("el promedio es: ");
        int[] array = { 1, 2, 3, 4, 5 };
        int i = 0;
        double prom = 0;
        System.out.println(promedio(array, i, prom));
    }

    public static double promedio(int[] array, int i, double prom) {
        double n = 0;
        if (i == array.length - 1) {
            prom = prom + array[i];
            n = prom / array.length;
        } else {
            prom = prom + array[i];
            n = n + promedio(array, i + 1, prom);
        }
        return n;
    }
}
