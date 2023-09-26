import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int P = teclado.nextInt();
        int B = teclado.nextInt();
        teclado.close();
        double V = (P * 0.12) + (B * 1.50);
        double G = V * 0.10;
        System.out.printf("%.2f\n%.2f\n", V, G);
    }
}
