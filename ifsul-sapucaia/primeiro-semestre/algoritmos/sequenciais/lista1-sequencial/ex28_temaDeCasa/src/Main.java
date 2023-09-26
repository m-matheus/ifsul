import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int X = teclado.nextInt();
        int Y = X * 60;
        System.out.printf("%d minutos\n", Y);
    }
}
