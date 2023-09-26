import java.util.Scanner;
public class Main 
{
    
	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		int X = teclado.nextInt();
		int centena = X / 100; // 2
		int dezena = (X % 100) / 10; // 3
		int unidade = (X % 100) % 10; // 5
		int numeroInverso = (unidade * 100) + (dezena * 10) + centena;
		int somaInverso = X + numeroInverso;
		int centenaInverso = somaInverso / 100;
		int dezenaInverso = (somaInverso % 100) / 10;
		int unidadeInverso = (somaInverso % 100) % 10;
		int calculoPosicional = (centenaInverso * 1) + (dezenaInverso * 2) + (unidadeInverso * 3);
		int codigo = calculoPosicional % 10;
		System.out.printf("%d\n", codigo);
	}

}