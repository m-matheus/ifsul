#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main()
{
	setlocale(LC_ALL, "Portuguese");
	
	
	int x; //declara��o de variavel
	printf("Digite qualquer n�mero:\n");
	scanf("%i",&x); //entrada de dados
	
	x=x*2; // processamento
	
	printf("Resultado: %i\n",x); //saida de dados
	
	
	system("pause");
	return(0);
}
