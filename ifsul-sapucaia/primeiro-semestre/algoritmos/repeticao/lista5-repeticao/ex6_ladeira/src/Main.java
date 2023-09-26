import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        int maior = 0;
        int menor = 0;
        
        do {
            maior = input.nextInt();
            menor = input.nextInt();
        } 
        while (maior <= menor);

        int output = menor;

        for (int i = 0; i <= (maior - menor); i++) {
            if (i < (maior - menor)) {
                System.out.printf("%d ", output);
            }
            else {
                System.out.printf("%d\n", output);
            }
            
            output += 1;
        }
        
        input.close();
    }
}
