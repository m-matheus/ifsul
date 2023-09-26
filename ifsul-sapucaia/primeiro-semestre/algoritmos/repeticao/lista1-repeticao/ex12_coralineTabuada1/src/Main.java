import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int tabuada = 0;        
        for (int i = 1; i <= 10; i++) {
            tabuada = N * i;
            System.out.printf("%d x %d = %d\n", i, N, tabuada);
        }
    }
}
