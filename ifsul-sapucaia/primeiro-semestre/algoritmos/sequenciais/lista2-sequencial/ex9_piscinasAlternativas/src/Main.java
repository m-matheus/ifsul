import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        double B = teclado.nextDouble();
        double H = teclado.nextDouble();
        teclado.close();
        double T = (B * H) / 2;
        double L = T * 2;
        System.out.printf("%.2f\n%.2f\n", T, L);
    }
}
