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
	printf("Digite o valor do salário: ");
	scanf("%d", &salario);
	
	printf("Digite o código da classe: ");
	scanf("%d", &classe);
	// Cálculo para cada caso
	switch(classe)
	{
		case 1: 
		{
			salariof = salario * 2;
			printf("O salário final é %d\n", salariof);
			printf("A classe é excelente!\n");
			break;
		}
			case 2: 
		{
			salariof = salario * 1.8;
			printf("O salário final é %d\n", salariof);
			printf("A classe é bom!\n");
			break;
		}
			case 3: 
		{
			salariof = salario * 1.5;
			printf("O salário final é %d\n", salariof);
			printf("A classe é médio!\n");
			break;
		}
			case 4: 
		{
			salariof = salario * 1.3;
			printf("O salário final é %d\n", salariof);
			printf("A classe é regular!\n");
			break;
		}
			case 5: 
		{
			salariof = salario * 1.1;
			printf("O salário final é %d\n", salariof);
			printf("A classe é precisa treinar mais!\n");
			break;
		}
			case 6: 
		{
			salariof = salario * 1.05;
			printf("O salário final é %d\n", salariof);
			printf("A classe é te cuida!\n");
			break;
		}
			case 7: 
		{
			salariof = salario;
			printf("O salário final é %d\n", salariof);
			printf("A classe é tsktsk!\n");
			break;
		}
	}	
	}
	
	return 0;
}
