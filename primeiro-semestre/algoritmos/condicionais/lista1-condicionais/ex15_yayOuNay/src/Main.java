import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        double X = teclado.nextDouble(); // palpite 1
        double Y = teclado.nextDouble(); // palpite 2
        double Z = teclado.nextDouble(); // palpite 3

        double somaPalpites = X + Y + Z;
        if ( somaPalpites == 100.0)
        {
            System.out.printf("%.2f\n", somaPalpites);
        }
        else
        {
            System.out.printf("%.2f\n%.2f\n%.2f\n", X, Y, Z);
        }

    }
}
