import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt(); // numero de convidados
        if (N % 11 == 0)
        {
            System.out.printf("OK\n");
        }
        else
        {
            System.out.printf("NO\n");
        }
    }
}
