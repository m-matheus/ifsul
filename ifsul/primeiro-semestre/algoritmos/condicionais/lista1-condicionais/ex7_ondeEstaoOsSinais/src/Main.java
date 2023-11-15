import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt();

        if (N > 0) 
        {
            System.out.printf("POS\n");
        }
        else
        {
            System.out.printf("NEG\n");
        }
    }
}
