#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
setlocale(LC_ALL, "Portuguese");
	//declara��o de vari�veis do tipo inteiro
int a, b, soma, produto;
	
	printf("Digite um numero inteiro:");
	scanf("%d", &a); //Recebe um inteiro e armazena na vari�vel a

	printf("Digite outro numero inteiro:");
	scanf("%d", &b); //Recebe um inteiro e armazena na vari�vel b
	
	soma = a + b;
	//Efetua adi��o de a com b e armazena na vari�vel soma
	produto = a * b;
	// Efetua a multiplica��o de a com b e armazena na vari�vel produto
	
	printf("Resultado da soma = %d\n", soma); //Mostra mensagem com o resultado
	printf("Resultado do produto = %d\n", produto);
system("Pause");
return(0);
}
