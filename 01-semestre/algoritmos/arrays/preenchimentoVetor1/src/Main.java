import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        int V = keyboard.nextInt();
        int[] X = new int[10];

        X[0] = V;

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                X[0] = V;
            }
            else {
                X[i] = X[i - 1];
                X[i] *= 2;
            }
            System.out.printf("N[%d] = %d\n", i, X[i]);
        }
        


    }
}
