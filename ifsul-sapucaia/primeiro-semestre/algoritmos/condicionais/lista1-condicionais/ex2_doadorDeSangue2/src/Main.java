import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt(); // idade do doador
        double X = teclado.nextDouble(); // peso do doador

        if ((N >= 16 && N <= 69) && (X >= 50))
        {
            System.out.printf("YES\n");
        }
        else
        {
            System.out.printf("NO\n");
        }
    }
}
