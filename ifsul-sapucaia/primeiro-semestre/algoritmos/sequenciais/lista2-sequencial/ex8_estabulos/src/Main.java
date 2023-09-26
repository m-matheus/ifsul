import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner teclado = new Scanner(System.in);
        double L = teclado.nextDouble();
        double P = L * 4;
        double A = Math.pow(L, 2);
        System.out.printf("%.2f\n%.2f\n", P, A);
    }
}
