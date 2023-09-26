import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] N = new int[1000];
        int T = teclado.nextInt();
        int multiplo = (1000 / T) * T;
        int resto = 1000 % T;
        int i;

        for (i = 0; i < multiplo; i += T) {
            for (int j = 0; j < T; j++) {
                N[i + j] = j;
            }
        }
        for (int k = 0; k < resto; k++) {
            N[i] = k;
            i++;
        }
        for (i = 0; i < 1000; i++) {
            System.out.println("N[" + i + "] = " + N[i]);
        }

        teclado.close();
    }

}