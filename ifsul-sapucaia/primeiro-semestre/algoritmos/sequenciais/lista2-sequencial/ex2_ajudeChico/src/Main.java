import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        double B = teclado.nextDouble();
        double H = teclado.nextDouble();
        double perimetro = (2 * B) + (2 * H);
        double area = B * H;
        double diagonal = Math.sqrt((Math.pow(B, 2) + Math.pow(H, 2)));
        System.out.printf("%.1f\n%.1f\n%.2f\n", perimetro, area, diagonal);
    }
}
