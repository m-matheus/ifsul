import java.util.Scanner;
public class Main 
{

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		double X = teclado.nextDouble();
		teclado.close();
		double Xfinal = (X * 1.28) * 1.45;
		System.out.printf("Preco total = R$ %.2f\n", Xfinal);
	}

}
