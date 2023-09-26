import java.util.Scanner;
public class Main
{

	public static void main(String[] args) 
	{
		double PI = 3.1415926;
		Scanner teclado = new Scanner(System.in);
		int r = teclado.nextInt();
		teclado.close();
		double a = PI * Math.pow(r, 2);
		System.out.printf("Area = %.2f", a);
	}

}
