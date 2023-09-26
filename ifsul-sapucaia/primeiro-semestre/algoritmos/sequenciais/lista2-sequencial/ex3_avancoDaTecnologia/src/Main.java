import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int X = teclado.nextInt();
        double Y = teclado.nextDouble();
        teclado.close();
        double multa = (((X / 3.0) * Y) * 12.0) * 1.0/100;
        double faturamentoAnual = (((X / 3.0) * Y) * 12.0) * 101/100;
        double totalDVD = (X * 98/100) * 110/100;
        System.out.printf("%.2f\n%.2f\n%.0f\n", faturamentoAnual, multa, totalDVD);
    }
}
