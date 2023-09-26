#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int dia, mes;
char nome[100];

printf("Digite o seu nome: \n");
gets(nome);

printf("Digite o dia do seu nascimento: \n");
scanf("%d", &dia);

printf("Digite o mês do seu nascimento: \n");
scanf("%d", &mes);

if (((mes == 3) && ((dia >= 20) && (dia <= 31))) || ((mes == 4) && ((dia >= 1) && (dia <= 20))))
{
	printf("\nOlá, %s!\nO seu signo é: Áries.\n\n", nome);
}
else if  (((mes == 4) && ((dia >= 21) && (dia <= 30))) || ((mes == 5) && ((dia >= 1) && (dia <= 20))))
{
	printf("\nOlá, %s!\nO seu signo é: Touro.\n\n", nome);
}
else if  (((mes == 5) && ((dia >= 21) && (dia <= 31))) || ((mes == 6) && ((dia >= 1) && (dia <= 20))))
{
	printf("\nOlá, %s!\nO seu signo é: Gêmeos.\n\n", nome);
}
else if  (((mes == 6) && ((dia >= 21) && (dia <= 30))) || ((mes == 7) && ((dia >= 1) && (dia <= 21))))
{
	printf("\nOlá, %s!\nO seu signo é: Câncer.\n\n", nome);
}
else if  (((mes == 7) && ((dia >= 22) && (dia <= 31))) || ((mes == 8) && ((dia >= 1) && (dia <= 22))))
{
	printf("\nOlá, %s!\nO seu signo é: Leão.\n\n", nome);
}
else if  (((mes == 8) && ((dia >= 23) && (dia <= 30))) || ((mes == 9) && ((dia >= 1) && (dia <= 22))))
{
	printf("\nOlá, %s!\nO seu signo é: Virgem.\n\n", nome);
}
else if  (((mes == 9) && ((dia >= 23) && (dia <= 31))) || ((mes == 10) && ((dia >= 1) && (dia <= 22))))
{
	printf("\nOlá, %s!\nO seu signo é: Libra.\n\n", nome);
}
else if  (((mes == 10) && ((dia >= 23) && (dia <= 30))) || ((mes == 11) && ((dia >= 1) && (dia <= 21))))
{
	printf("\nOlá, %s!\nO seu signo é: Escorpião.\n\n", nome);
}
else if  (((mes == 11) && ((dia >= 22) && (dia <= 31))) || ((mes == 12) && ((dia >= 1) && (dia <= 21))))
{
	printf("\nOlá, %s!\nO seu signo é: Sagitário.\n\n", nome);
}
else if  (((mes == 12) && ((dia >= 22) && (dia <= 30))) || ((mes == 1) && ((dia >= 1) && (dia <= 20))))
{
	printf("\nOlá, %s!\nO seu signo é: Capricórnio.\n\n", nome);
}
else if  (((mes == 1) && ((dia >= 21) && (dia <= 31))) || ((mes == 2) && ((dia >= 1) && (dia <= 18))))
{
	printf("\nOlá, %s!\nO seu signo é: Aquário.\n\n", nome);
}
else if  (((mes == 2) && ((dia >= 19) && (dia <= 30))) || ((mes == 3) && ((dia >= 1) && (dia <= 19))))
{
	printf("\nOlá, %s!\nO seu signo é: Peixes.\n\n", nome);
}
else
{
	printf("\nOlá, %s!\nNão identifiquei uma data válida.\n\n", nome);
}
system("Pause");
return(0);
}

