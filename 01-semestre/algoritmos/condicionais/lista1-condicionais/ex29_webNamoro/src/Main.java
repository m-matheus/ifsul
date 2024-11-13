import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner teclado = new Scanner(System.in);
        int X = teclado.nextInt();
        int Y = teclado.nextInt();

        if (X > Y)
        {
            System.out.println("NEWER");
        }
        else if (X == Y)
        {
            System.out.println("SAME");
        }
        else
        {
            System.out.println("OLDER");
        }
    }
}
