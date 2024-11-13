import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int A = teclado.nextInt();
        int B = teclado.nextInt();
        int C = teclado.nextInt();
        int D = teclado.nextInt();
        
        if (A + B != C + D)
        {
            System.out.printf("%d\n", A + B);
            System.out.printf("%d\n", C + D);
        }
        else
        {
            System.out.printf("%d + %d = %d\n", A, B, A + B);
            System.out.printf("%d + %d = %d\n", C, D, C + D);
        }
    }
}
