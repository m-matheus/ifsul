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

printf("Digite o m�s do seu nascimento: \n");
scanf("%d", &mes);

if (((mes == 3) && ((dia >= 20) && (dia <= 31))) || ((mes == 4) && ((dia >= 1) && (dia <= 20))))
{
	printf("\nOl�, %s!\nO seu signo �: �ries.\n\n", nome);
}
else if  (((mes == 4) && ((dia >= 21) && (dia <= 30))) || ((mes == 5) && ((dia >= 1) && (dia <= 20))))
{
	printf("\nOl�, %s!\nO seu signo �: Touro.\n\n", nome);
}
else if  (((mes == 5) && ((dia >= 21) && (dia <= 31))) || ((mes == 6) && ((dia >= 1) && (dia <= 20))))
{
	printf("\nOl�, %s!\nO seu signo �: G�meos.\n\n", nome);
}
else if  (((mes == 6) && ((dia >= 21) && (dia <= 30))) || ((mes == 7) && ((dia >= 1) && (dia <= 21))))
{
	printf("\nOl�, %s!\nO seu signo �: C�ncer.\n\n", nome);
}
else if  (((mes == 7) && ((dia >= 22) && (dia <= 31))) || ((mes == 8) && ((dia >= 1) && (dia <= 22))))
{
	printf("\nOl�, %s!\nO seu signo �: Le�o.\n\n", nome);
}
else if  (((mes == 8) && ((dia >= 23) && (dia <= 30))) || ((mes == 9) && ((dia >= 1) && (dia <= 22))))
{
	printf("\nOl�, %s!\nO seu signo �: Virgem.\n\n", nome);
}
else if  (((mes == 9) && ((dia >= 23) && (dia <= 31))) || ((mes == 10) && ((dia >= 1) && (dia <= 22))))
{
	printf("\nOl�, %s!\nO seu signo �: Libra.\n\n", nome);
}
else if  (((mes == 10) && ((dia >= 23) && (dia <= 30))) || ((mes == 11) && ((dia >= 1) && (dia <= 21))))
{
	printf("\nOl�, %s!\nO seu signo �: Escorpi�o.\n\n", nome);
}
else if  (((mes == 11) && ((dia >= 22) && (dia <= 31))) || ((mes == 12) && ((dia >= 1) && (dia <= 21))))
{
	printf("\nOl�, %s!\nO seu signo �: Sagit�rio.\n\n", nome);
}
else if  (((mes == 12) && ((dia >= 22) && (dia <= 30))) || ((mes == 1) && ((dia >= 1) && (dia <= 20))))
{
	printf("\nOl�, %s!\nO seu signo �: Capric�rnio.\n\n", nome);
}
else if  (((mes == 1) && ((dia >= 21) && (dia <= 31))) || ((mes == 2) && ((dia >= 1) && (dia <= 18))))
{
	printf("\nOl�, %s!\nO seu signo �: Aqu�rio.\n\n", nome);
}
else if  (((mes == 2) && ((dia >= 19) && (dia <= 30))) || ((mes == 3) && ((dia >= 1) && (dia <= 19))))
{
	printf("\nOl�, %s!\nO seu signo �: Peixes.\n\n", nome);
}
else
{
	printf("\nOl�, %s!\nN�o identifiquei uma data v�lida.\n\n", nome);
}
system("Pause");
return(0);
}

