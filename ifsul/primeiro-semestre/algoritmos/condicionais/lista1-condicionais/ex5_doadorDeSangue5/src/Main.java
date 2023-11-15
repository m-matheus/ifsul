import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        java.util.Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt(); // idade doador
        double X = teclado.nextDouble(); // peso doador
        String jejum = teclado.next(); // (YES/NO) jejum
        String documento = teclado.next(); // (YES/NO) documento
        String hepatite = teclado.next(); // (YES/NO) hepatite

        if ((N >= 16 && N <= 69) && (X >= 50))
        {
            if ((jejum.equals("YES")) && (documento.equals("YES")))
            {
                if (hepatite.equals("NO"))
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
        else
        {
            System.out.printf("NO\n");
        }
    }
}
