import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt(); // idade doador
        double X = teclado.nextDouble(); // peso doador
        String jejum = teclado.next(); // (YES/NO) jejum

        if ((N >= 16 && N <= 69) && (X >= 50))
        {
            if (jejum.equals("YES"))
            {
                System.out.printf("YES\n");
            }
            else
            {
                System.out.printf("NO\n");
            }
        }
        else
        {
            System.out.printf("NO\n");
        }
    }
}
