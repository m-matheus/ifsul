import java.util.Scanner;
public class Main
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        int N = teclado.nextInt();
        teclado.close();
        double R = Math.sqrt(N);
        System.out.printf("%.2f\n", R);
    }
}
