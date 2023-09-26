#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>

int main(void)
{
	setlocale(LC_ALL, "Portuguese");
	int clube;
	int cidade, pessoas=0;
	int gremio=0, internacional=0, outros=0;
	int porto=0, outrasCidade=0;
	int pessoasNenhumClube=0;
	
	// Looping de entrada
	do
	{
	printf("Clube de preferência (1- Grêmio, 2- Internacional, 3- Outros): ");
	scanf("%d", &clube);
	
	printf("Cidade de origem (0- Porto Alegre, 1- Outras): ");
	scanf("%d", &cidade);
	// Cálculo para cada caso
	switch(clube)
	{	
		case 1: 
		{
			gremio++;
			break;
		}
			case 2: 
		{
			internacional++;
			break;
		}
			case 3: 
		{
			outros++;
			break;
		}
	}
	switch(cidade)
	{
		case 0: 
		{
			porto++;
			break;
		}
			case 1: 
		{
			outrasCidade++;
			break;
		}
	}
	pessoas++;
	// Condição POA + outros clubes
	if (cidade == 0 && clube == 3)
	{
		pessoasNenhumClube++;
	}
	}
	while (clube != 0);
	// Consistência dos dados de entrada
	pessoas = pessoas - 1;
	// Impressão dos valores
	printf("Número de torcedores do Grêmio: %d\n", gremio);
	printf("Número de torcedores do Internacional: %d\n", internacional);
	printf("Número de torcedores de outros clubes: %d\n", outros);
	printf("Número de pessoas que moram em POA, mas não torcem para o inter nem para o grêmio: %d\n", pessoasNenhumClube);
	printf("Número de pessoas entrevistadas: %d\n", pessoas);
	
	return 0;
}
