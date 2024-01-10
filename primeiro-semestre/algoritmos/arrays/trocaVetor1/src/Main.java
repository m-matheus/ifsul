import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        int[] N = new int[20];
        int aux = 0;

        for (int i = 0; i < 20; i++) {
            N[i] = keyboard.nextInt();
        }

        for (int j = 0, k = 19; j < k; j++, k--) {
            aux = N[j];
            N[j] = N[k];
            N[k] = aux;
        }

        for (int l = 0; l < 20; l++) {
            System.out.printf("N[%d] = %d\n", l, N[l]);
        }
    }
}
