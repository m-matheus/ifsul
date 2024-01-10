import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int N1 = teclado.nextInt();
        int N2 = teclado.nextInt();
        int N3 = teclado.nextInt();

        // par = filme 1
        // impar = filme 2
        
        int par = 0;
        int impar = 0;

        if (N1 % 2 == 0)
        {
            par++;
        }
        else
        {
            impar++;
        }
        if (N2 % 2 == 0)
        {
            par++;
        }
        else
        {
            impar++;
        }
        if (N3 % 2 == 0)
        {
            par++;
        }
        else
        {
            impar++;
        }

        if (impar > par)
        {
            System.out.printf("2\n");
        }
        else
        {
            System.out.printf("1\n");
        }
    }
}
