import java.util.Scanner;
public class Main 
{

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		int A = teclado.nextInt();
		int B = teclado.nextInt();
		int C = teclado.nextInt();
		teclado.close();
		double A350 = A * 0.35;
		double B600 = B * 0.6;
		double C2000 = C * 2;
		double total = A350 + B600 + C2000;
		System.out.printf("Total de litros comprados: %.1f\n", total);
	}

}
