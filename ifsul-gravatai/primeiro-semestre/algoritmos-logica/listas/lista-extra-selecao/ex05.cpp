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
printf("|Saldo m�dio          | Percentual                  |\n");
printf("+---------------------+-----------------------------+\n");
printf("|de 0 a 200,00        | Nenhum cr�dito (cr�dito = 0)|\n");
printf("|de 201,00 a 400,00   | 20%% do valor do saldo m�dio |\n");
printf("|de 401,00 a 600,00   | 30%% do valor do saldo m�dio |\n");
printf("|acima de 600,00      | 40%% do valor do saldo m�dio |\n");
printf("+---------------------+-----------------------------+\n\n\n");
printf("Digite o seu saldo m�dio: ");
scanf("%f", &saldomedio);

if (saldomedio > 0 && saldomedio < 200) 
{
	printf("\n\nO seu saldo m�dio �: %.2f\nValor de cr�dito liberado: Nenhum cr�dito.\n\n\n", saldomedio);
}
else if (saldomedio > 200 && saldomedio < 401)
{
	perc = saldomedio * .2;
	printf("\n\nO seu saldo m�dio � %.2f\nValor de cr�dito liberado: %.2f. \n\n\n)", saldomedio, perc);
}
else if (saldomedio > 400 && saldomedio < 601)
{
	perc = saldomedio * .3;
	printf("\n\nO seu saldo m�dio � %.2f\nValor de cr�dito liberado: %.2f. \n\n\n)", saldomedio, perc);
}
else if (saldomedio > 400 && saldomedio < 601)
{
	perc = saldomedio * .3;
	printf("\n\nO seu saldo m�dio � %.2f\nValor de cr�dito liberado: %.2f. \n\n\n)", saldomedio, perc);
}
else if (saldomedio > 600)
{
	perc = saldomedio * .4;
	printf("\n\nO seu saldo m�dio � %.2f\nValor de cr�dito liberado: %.2f. \n\n\n)", saldomedio, perc);
}

system("Pause");
return(0);
}

