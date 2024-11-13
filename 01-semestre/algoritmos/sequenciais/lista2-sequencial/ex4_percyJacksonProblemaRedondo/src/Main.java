import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        double R = teclado.nextDouble();
        teclado.close();
        double perimetro = 2 * 3.14 * R;
        double area = 3.14 * Math.pow(R, 2);
        System.out.printf("%.2f\n%.2f\n", perimetro, area);
    }
}
