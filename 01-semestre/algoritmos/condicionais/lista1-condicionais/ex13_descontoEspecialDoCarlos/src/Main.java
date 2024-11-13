import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt();

        if ((N > 9) && (N < 21))
        {
            System.out.println("10%");
        }
        else if ((N > 20) && (N < 31))
        {
            System.out.println("5%");
        }
        else if (N > 89)
        {
            System.out.println("20%");
        }
    }
}
