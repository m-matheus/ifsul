import java.util.Scanner;
public class Main 
{

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		double P = teclado.nextDouble();
		double C = teclado.nextDouble();
		int V = teclado.nextInt();
		int R = teclado.nextInt();
		teclado.close();
		double combustivelMin = (((V / (R + 1.0)) * P) / C) / 1000.0;
		
		System.out.printf("%.1f litros\n", combustivelMin);
	}

}
