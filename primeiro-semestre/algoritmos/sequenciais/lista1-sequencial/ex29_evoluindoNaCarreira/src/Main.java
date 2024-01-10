import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int P = teclado.nextInt();
        int N = teclado.nextInt();
        teclado.close();
        int pesoInicial = P * 1000;
        double pesoMais12 = P * 1.12;
        double pesoFinal = (pesoMais12 + (pesoMais12 * N/100));
        System.out.printf("Gramas = %dg\nPeso depois dos 12%% = %.2fkg\nPeso final = %.2fkg\n", pesoInicial, pesoMais12, pesoFinal);
    }
}
