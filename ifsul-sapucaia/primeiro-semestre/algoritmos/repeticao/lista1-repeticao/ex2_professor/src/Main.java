import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        String P;
        int N = 0;
        do {
            P = input.nextLine().toUpperCase();
            if (P.equals("PROFESSOR")) {
                N++;
            }
        } while (!P.equals("0"));
        System.out.println(N);
    }
}
