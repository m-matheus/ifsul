import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int X = teclado.nextInt();
        int Y = teclado.nextInt();
        int Z = teclado.nextInt();
        if ((X > Y) && (X > Z))
        {
            System.out.println("DU WON");
        }
        else if ((Y > X) && (Y > Z))
        {
            System.out.println("DUDU WON"); 
        }
        else if ((Z > X) && (Z > Y))
        {
            System.out.println("EDU WON"); 
        }

        if ((X < Y) && (X < Z))
        {
            System.out.println("DU LOST");
        }
        else if ((Y < X) && (Y < Z))
        {
            System.out.println("DUDU LOST"); 
        }
        else if ((Z < X) && (Z < Y))
        {
            System.out.println("EDU LOST"); 
        }

    }
}
