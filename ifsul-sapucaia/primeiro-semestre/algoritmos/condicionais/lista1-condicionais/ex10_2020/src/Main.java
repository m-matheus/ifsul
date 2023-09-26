import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt();

        if (N < 20) 
        {
            System.out.printf("TAG\n");
        }
        else if (N == 20)
        {
            System.out.printf("VIP\n");
        }
        else
        {
            System.out.printf("ABEND\n");
        }
    }
}
