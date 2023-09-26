import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int X = 0;
        int cont = 0;
        
        do {
            X = input.nextInt();

            if ((X >= 100) && (X <= 200)) {
                cont++;
            }
        }
        while (X != 0);

        System.out.println(cont);

        input.close();
    }
}
