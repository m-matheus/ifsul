import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int A = 0;
        int menor = Integer.MAX_VALUE;
        int maior = Integer.MIN_VALUE;
        int posicaoMenor = 0;
        int posicaoMaior = 0;

        for (int i = 0; i < 10; i++) {
            A = input.nextInt();

            if (A < menor) {
                menor = A;
                posicaoMenor = i;
            }
            
            if (A >= maior) {
                maior = A;
                posicaoMaior = i;
            }
        }
        
        System.out.println(posicaoMenor + 1);
        System.out.println(posicaoMaior + 1);
    }
}
