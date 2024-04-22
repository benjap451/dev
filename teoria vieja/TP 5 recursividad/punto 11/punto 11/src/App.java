public class App {
    public static void main(String[] args) throws Exception {
        int i = 0, par = 0, impar = 0;
        sumasPI(i, par, impar);
    }

    public static void sumasPI(int i, int par, int impar) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
        if (i >= a.length) {
            System.out.println("la suma par es: " + par + " la suma impar es: " + impar);
        } else {
            if (a[i] % 2 == 0) {
                par = par + a[i];
            } else {
                impar = impar + a[i];
            }
            sumasPI(i + 1, par, impar);
        }
    }
}
