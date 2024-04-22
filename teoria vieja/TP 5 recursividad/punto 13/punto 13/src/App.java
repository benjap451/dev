public class App {
    public static void main(String[] args) throws Exception {
        int[][] matriz = { { 1, 2, 3, 4 }, { 5, 40, 7, 8 }, { 20, 8, 9, 1 } };
        int i = 0, j = 0, k = matriz[i][j];
        System.out.println("el valor mas grande es: " + numGrande(matriz, i, j, k));
    }

    public static int numGrande(int[][] matriz, int i, int j, int k) {
        System.out.println(i + " - " + j);
        int a = k;
        if (matriz[i][j] > k) {
            k = matriz[i][j];
        }
        if (j < matriz[0].length - 1 && i < matriz.length) {
            a = numGrande(matriz, i, j + 1, k);

        } else if (j == matriz[0].length - 1 && i < matriz.length - 1) {
            j = 0;
            a = numGrande(matriz, i + 1, j, k);
        }
        if (a > k) {
            k = a;
        }
        return k;
    }
}
