import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);

        while (keyboard.hasNextInt()) {
            int size = keyboard.nextInt();
            int[][] N = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if ((i + j) == (size - 1)) {
                        N[i][j] = 2;
                    } else if (i == j) {
                        N[i][j] = 1;
                    } else {
                        N[i][j] = 3;
                    }
                    System.out.printf("%d", N[i][j]);
                }
                System.out.println();
            }
        }
        keyboard.close();
    }
}
