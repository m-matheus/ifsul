import java.util.Scanner;
public class Main 
{

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		double X = teclado.nextInt();
		double J = teclado.nextInt();
		double F = teclado.nextInt();
		teclado.close();
		double porcJ = (J * 100) / X;
		double porcF = (F * 100) / X;
		double votosNulos = ((X - (J + F)) * 100) / X;
		System.out.printf("João : %.2f%%\n", porcJ);
		System.out.printf("Fernanda : %.2f%%\n", porcF);
		System.out.printf("Votos nulos : %.2f%%\n", votosNulos);
		
	}

}
