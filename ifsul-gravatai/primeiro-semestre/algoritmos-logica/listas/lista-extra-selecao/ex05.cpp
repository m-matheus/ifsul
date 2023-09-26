#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

float saldomedio, perc;

printf("+---------------------+-----------------------------+\n");
printf("|Saldo médio          | Percentual                  |\n");
printf("+---------------------+-----------------------------+\n");
printf("|de 0 a 200,00        | Nenhum crédito (crédito = 0)|\n");
printf("|de 201,00 a 400,00   | 20%% do valor do saldo médio |\n");
printf("|de 401,00 a 600,00   | 30%% do valor do saldo médio |\n");
printf("|acima de 600,00      | 40%% do valor do saldo médio |\n");
printf("+---------------------+-----------------------------+\n\n\n");
printf("Digite o seu saldo médio: ");
scanf("%f", &saldomedio);

if (saldomedio > 0 && saldomedio < 200) 
{
	printf("\n\nO seu saldo médio é: %.2f\nValor de crédito liberado: Nenhum crédito.\n\n\n", saldomedio);
}
else if (saldomedio > 200 && saldomedio < 401)
{
	perc = saldomedio * .2;
	printf("\n\nO seu saldo médio é %.2f\nValor de crédito liberado: %.2f. \n\n\n)", saldomedio, perc);
}
else if (saldomedio > 400 && saldomedio < 601)
{
	perc = saldomedio * .3;
	printf("\n\nO seu saldo médio é %.2f\nValor de crédito liberado: %.2f. \n\n\n)", saldomedio, perc);
}
else if (saldomedio > 400 && saldomedio < 601)
{
	perc = saldomedio * .3;
	printf("\n\nO seu saldo médio é %.2f\nValor de crédito liberado: %.2f. \n\n\n)", saldomedio, perc);
}
else if (saldomedio > 600)
{
	perc = saldomedio * .4;
	printf("\n\nO seu saldo médio é %.2f\nValor de crédito liberado: %.2f. \n\n\n)", saldomedio, perc);
}

system("Pause");
return(0);
}

