import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int somaMedia = 0;
        int fator = 0;
        int somaTotal = 0;

        for (int i = 0; i < 8; i++) {
            int N = input.nextInt();
            somaTotal += N;
            if (N > 20) {
                somaMedia += N;
                fator++;
            }
        }
        
        double media = 0;
        media = (double) somaMedia / fator;

        if (somaMedia == 0) {
            System.out.println(somaTotal);
            System.out.println(0);
        }
        else{
            System.out.println(somaTotal);
            System.out.printf("%.2f\n", media);
        }
        
        input.close();
    }
}
