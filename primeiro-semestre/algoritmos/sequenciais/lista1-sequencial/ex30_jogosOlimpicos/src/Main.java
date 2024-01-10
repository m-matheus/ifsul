import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int X = teclado.nextInt();
        double Y = teclado.nextDouble();
        teclado.close();
        double valorPromo = Y * 0.75;
        double valor100 = valorPromo * X;
        double valor70 = valorPromo * (0.70 * X);
        double valorPerdido = (X * Y) - valor100;
        System.out.printf("R$ %.2f\nR$ %.2f\nR$ %.2f\nR$ %.2f\n", valorPromo, valor100, valor70, valorPerdido);
    }
}
