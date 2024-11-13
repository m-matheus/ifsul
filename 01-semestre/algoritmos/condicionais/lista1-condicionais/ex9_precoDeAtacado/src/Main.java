import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt(); // quantidade de produto da loja

        if (N > 19)
        {
            System.out.printf("YES\n");
        }
        else
        {
            System.out.printf("NO\n");
        }
    }
}
