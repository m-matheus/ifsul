import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt();
        if ((N % 3 == 0) && (N % 7 == 0))
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }
}
