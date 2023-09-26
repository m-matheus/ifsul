import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        double P = teclado.nextDouble();
        teclado.close();
        double V = P * 12;
        System.out.printf("%.2f\n", V);
    }
}
