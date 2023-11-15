import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt();

        if ((N > 19) && (N < 31))
        {
            System.out.println("15%");
        }
        else if ((N > 49) && (N < 61))
        {
            System.out.println("10%");
        }
        else
        {
            System.out.println("NO");
        }
    }
}
