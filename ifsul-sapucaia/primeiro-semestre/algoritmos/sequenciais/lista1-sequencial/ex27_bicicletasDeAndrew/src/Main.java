import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int E = teclado.nextInt();
        int V = teclado.nextInt();
        double S = teclado.nextDouble();
        double B = teclado.nextDouble();
        double salario = (S * 2) + (((B * 0.15) * V) / E);
        double lucro = (B * V * 1.5 ) - (salario * E) - (B * V);
        System.out.printf("Salario = R$%.2f\n", salario);
        System.out.printf("Lucro = R$%.2f\n", lucro);
    }
}
