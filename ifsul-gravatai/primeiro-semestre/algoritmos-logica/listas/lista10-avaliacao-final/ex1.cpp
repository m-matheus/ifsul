#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>

int main(void)
{
	setlocale(LC_ALL, "Portuguese");
	int classe;
	int salario, salariof;
	
	// Looping de entrada
	while (classe > 0 && classe < 8)
	{
	printf("Digite o valor do sal�rio: ");
	scanf("%d", &salario);
	
	printf("Digite o c�digo da classe: ");
	scanf("%d", &classe);
	// C�lculo para cada caso
	switch(classe)
	{
		case 1: 
		{
			salariof = salario * 2;
			printf("O sal�rio final � %d\n", salariof);
			printf("A classe � excelente!\n");
			break;
		}
			case 2: 
		{
			salariof = salario * 1.8;
			printf("O sal�rio final � %d\n", salariof);
			printf("A classe � bom!\n");
			break;
		}
			case 3: 
		{
			salariof = salario * 1.5;
			printf("O sal�rio final � %d\n", salariof);
			printf("A classe � m�dio!\n");
			break;
		}
			case 4: 
		{
			salariof = salario * 1.3;
			printf("O sal�rio final � %d\n", salariof);
			printf("A classe � regular!\n");
			break;
		}
			case 5: 
		{
			salariof = salario * 1.1;
			printf("O sal�rio final � %d\n", salariof);
			printf("A classe � precisa treinar mais!\n");
			break;
		}
			case 6: 
		{
			salariof = salario * 1.05;
			printf("O sal�rio final � %d\n", salariof);
			printf("A classe � te cuida!\n");
			break;
		}
			case 7: 
		{
			salariof = salario;
			printf("O sal�rio final � %d\n", salariof);
			printf("A classe � tsktsk!\n");
			break;
		}
	}	
	}
	
	return 0;
}
