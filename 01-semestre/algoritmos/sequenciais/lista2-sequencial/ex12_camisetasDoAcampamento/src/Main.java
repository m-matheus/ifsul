import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int P = teclado.nextInt();
        int M = teclado.nextInt();
        int G = teclado.nextInt();
        teclado.close();
        int V = (P * 10) + (M * 12) + (G * 15);
        System.out.printf("%d\n", V);
    }
}
