import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int C = teclado.nextInt();
        teclado.close();
        int F = C * 4;
        System.out.printf("%d\n", F);
    }
}