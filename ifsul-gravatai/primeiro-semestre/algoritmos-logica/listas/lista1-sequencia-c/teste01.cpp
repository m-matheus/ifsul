#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
setlocale(LC_ALL, "Portuguese");
	//declaração de variáveis do tipo inteiro
int a, b, soma, produto;
	
	printf("Digite um numero inteiro:");
	scanf("%d", &a); //Recebe um inteiro e armazena na variável a

	printf("Digite outro numero inteiro:");
	scanf("%d", &b); //Recebe um inteiro e armazena na variável b
	
	soma = a + b;
	//Efetua adição de a com b e armazena na variável soma
	produto = a * b;
	// Efetua a multiplicação de a com b e armazena na variável produto
	
	printf("Resultado da soma = %d\n", soma); //Mostra mensagem com o resultado
	printf("Resultado do produto = %d\n", produto);
system("Pause");
return(0);
}
