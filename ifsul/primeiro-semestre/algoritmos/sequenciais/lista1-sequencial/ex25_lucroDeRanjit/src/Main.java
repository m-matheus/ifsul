import java.util.Scanner;
public class Main 
{

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		double I = teclado.nextDouble();
		double F = teclado.nextDouble();
		double L = teclado.nextDouble();
		double V = teclado.nextDouble();
		teclado.close();
		double mediaConsumo = (F - I) / L;
		double lucro = V - (L * 2.5);
		System.out.printf("Media de consumo: %.2f Km/l\nLucro: $%.2f\n", mediaConsumo, lucro);
	}

}
