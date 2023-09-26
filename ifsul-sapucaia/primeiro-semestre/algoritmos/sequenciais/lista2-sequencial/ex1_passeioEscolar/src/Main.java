import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner teclado = new Scanner(System.in);
        double X = teclado.nextDouble();
        double valorPromo = X * 0.78;
        double valorMesSemPromo = X * (42 * 0.40) * 30;
        double valorMesComPromo = valorPromo * (42 * 0.70) * 30;
        double lucroPrejuizo = valorMesComPromo - valorMesSemPromo;
        System.out.printf("R$ %.2f\nR$ %.2f\nR$ %.2f\nR$ %.2f\n", valorPromo, valorMesSemPromo, valorMesComPromo, lucroPrejuizo);
    }
}
