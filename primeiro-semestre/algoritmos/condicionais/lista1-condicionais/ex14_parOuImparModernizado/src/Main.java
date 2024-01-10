import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int X = teclado.nextInt();
        int Y = teclado.nextInt();

        if (((X + Y) % 2) == 0)
        {
            System.out.println("EVEN");
        }
        else
        {
            System.out.println("ODD");
        }
    }
}
