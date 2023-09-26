import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            int atendeCondicao = 0;
            double media = 0;
            int foraIntervalo = 0;
            int soma = 0;

            for (int i = 0; i < 10; i++) {
                int X = input.nextInt();
                
                if (X % 2 == 0) {
                    if (((X >= 20) && (X <= 50))) {
                        atendeCondicao++;
                        soma += X;
                    }
                    else {
                        foraIntervalo++;
                    }
                }
                else {  
                   foraIntervalo++;
                }

                if (atendeCondicao == 0) {
                    media = 0;
                }
            }
            
            media = (double) soma / (double) atendeCondicao;

            System.out.printf("%.2f\n", media);
            System.out.println(atendeCondicao);
            System.out.println(foraIntervalo);

        }

        input.close();
    }
}
