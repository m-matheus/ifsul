import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int X = 0;
        int N = 0;
        int pessoasIdade = 0;
        
        N = input.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 6; j++) {
                X = input.nextInt();
                if (((X >= 30) && (X <= 60))) {
               pessoasIdade++; 
            }
            }
            System.out.println(pessoasIdade);
            pessoasIdade = 0;
        }
        
        input.close();
    }
}
