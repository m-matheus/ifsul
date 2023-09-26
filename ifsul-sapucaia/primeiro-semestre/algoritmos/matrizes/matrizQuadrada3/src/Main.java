import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        int N = Integer.MIN_VALUE;
        // pedir entrada até digitar 0
        while (N != 0) {

            // variavel de entrada
            N = keyboard.nextInt();

            // criando a matriz
            int[][] M = new int[N][N];

            // encontra maior numero NA matriz
            int maxNumber = (int) Math.pow(2, 2 * (N - 1));
            int T = String.valueOf(maxNumber).length();

            // preenchendo a matriz
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = (int) Math.pow(2, i + j);
                }
            }

            // imprimindo matriz formatada
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.printf("%" + T + "d", M[i][j]);
                    if (j < (N - 1)) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            System.out.println(); // linha em branco depois da matriz
        }

        keyboard.close();
    }
}
