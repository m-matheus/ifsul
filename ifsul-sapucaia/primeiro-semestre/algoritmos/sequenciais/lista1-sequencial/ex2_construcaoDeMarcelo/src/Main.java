import java.util.Scanner;
public class Main 
{

	public static void main(String[] args) 
	{	
		Scanner teclado = new Scanner(System.in);
		int x1 = teclado.nextInt();
		int y1 = teclado.nextInt();
		int x2 = teclado.nextInt();
		int y2 = teclado.nextInt();
		teclado.close();
		double d = Math.sqrt(Math.pow((x2 - x1), 2) - Math.pow((y2 - y1), 2));
		System.out.printf("%.2f", d);
	}

}
