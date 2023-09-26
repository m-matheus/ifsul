import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        int N = input.nextInt();
        int soma = 0;
        int cont = 0;
        double media = 0;
        int menor = Integer.MAX_VALUE;
        int maior = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int A = input.nextInt();

            if (A > 0) {
                soma += A;
                cont++;
                if (A < menor) {
                    menor = A;
                }
                if (A > maior) {
                    maior = A;
                }
            }

        }
        media = (double) soma / (double) cont;

        System.out.println(soma);
        System.out.printf("%.1f\n", media);
        System.out.println(maior);
        System.out.println(menor);
        
        input.close();
    }
}
