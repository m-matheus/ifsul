import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int A = teclado.nextInt();
        int B = teclado.nextInt();
    
        if (A * B >= 75)
        {
            System.out.printf("%d %d\n%d\n", A, B, A * B);
        }
        else
        {
            System.out.printf("%d %d\n%d\n", A, B, A + B);  
        }
    }
}
