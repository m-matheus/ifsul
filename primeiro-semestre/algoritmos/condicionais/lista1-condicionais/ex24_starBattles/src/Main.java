import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt(); // numero de pessoas
        if (N % 5 == 0)
        {
            System.out.printf("YES\n");
        }
        else if (N % 9 == 0)
        {
            System.out.printf("YES\n");
        }
        else
        {
            System.out.printf("NO\n");  
        }
    }
}
