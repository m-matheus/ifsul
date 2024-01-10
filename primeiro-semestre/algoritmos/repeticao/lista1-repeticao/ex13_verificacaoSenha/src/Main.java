import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int N = 0;
        int tentativaSenha = 0;
        while (N != 2014) {
            N = input.nextInt();
            tentativaSenha++;
            if (N != 2014) {
                System.out.println("ACCESS DENIED");
            }
            else {
                System.out.printf("ACCESS GRANTED.\nThe password was typed %d times.\n", tentativaSenha);
            }
        }
        input.close();
    }
}
