import java.util.Scanner;
public class Main 
{

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		double V = teclado.nextDouble();
		double valorDesc = V * 0.09;
		double valorFinal = V - valorDesc;
		teclado.close();
		System.out.printf("Valor original do produto: R$%.2f\n", V);
		System.out.printf("Valor final do produto: R$%.2f\n", valorFinal);
		System.out.printf("Valor do desconto: R$%.2f\n", valorDesc);
		
	}

}
