import java.util.Scanner;
public class Main 
{

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		int N = teclado.nextInt();
		teclado.close();
		int minutos = N * 60;
		System.out.printf("%d minutos\n", minutos);
	}

}
