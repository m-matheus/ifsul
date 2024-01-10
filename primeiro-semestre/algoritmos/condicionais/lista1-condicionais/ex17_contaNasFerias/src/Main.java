import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        double A = teclado.nextDouble();
        double B = teclado.nextDouble();
        double C = teclado.nextDouble();
        
        int neg = 0;

        if ((A < 0) || (B < 0) || (C < 0))
        {
            neg++;
        }
        System.out.printf("%d\n", neg);
    }
}
