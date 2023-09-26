import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt();

        if (N > 0)
        {
            double raiz = Math.sqrt(N);
            System.out.printf("%.2f\n", raiz);
        }
        else
        {
            double pot = Math.pow(N, 2);
            System.out.printf("%.2f\n", pot);
        }
    }
}
