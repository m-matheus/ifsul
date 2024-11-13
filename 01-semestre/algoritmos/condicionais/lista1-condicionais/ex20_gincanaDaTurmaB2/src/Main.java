import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int A = teclado.nextInt();
        int B = teclado.nextInt();

        if (A + B > 20)
        {
            System.out.printf("%d\n", A + B + 8);
        }
        else
        {
            System.out.printf("%d\n", A + B - 5);
        }
    }
}
