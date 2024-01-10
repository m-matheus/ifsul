import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        double salario = teclado.nextDouble();
        double prestacao = teclado.nextDouble();

        if (prestacao > (.30 * salario))
        {
            System.out.printf("NO\n");
        }
        else
        {
            System.out.printf("YES\n");
        }
    }
}
