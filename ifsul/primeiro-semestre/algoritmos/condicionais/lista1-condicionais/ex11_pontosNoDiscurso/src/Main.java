import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt(); // numero de linhas 

        if ((N > 19) && (N < 91))
        {
            System.out.printf("OK\n");
        }
        else
        {
            System.out.printf("3P\n");
        }

    }
}
