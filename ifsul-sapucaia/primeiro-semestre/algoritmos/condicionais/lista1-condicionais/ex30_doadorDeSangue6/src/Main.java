import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt(); // idade
        double P = teclado.nextDouble(); // peso
        String J = teclado.next(); // jejum ou nao
        String D = teclado.next(); // documento com foto ou nao
        String H = teclado.next(); // hepatite ou nao
        String M = teclado.next(); // malaria ou nao

        if (N >= 16 && N <= 69)
        {
            if ((J.equalsIgnoreCase("YES")) && (D.equalsIgnoreCase("YES")))
            {
                if (H.equalsIgnoreCase("NO"))
                {
                    if (M.equalsIgnoreCase("NO"))
                    {
                        System.out.printf("YES.\n");
                    }
                    else
                    {
                        System.out.printf("NO.\n");
                    }
                }
                else
                {
                    System.out.printf("NO.\n");
                }
            }
            else
            {
                System.out.printf("NO.\n");
            }
        }
        else
        {
            System.out.printf("NO.\n");
        }
    }
}
