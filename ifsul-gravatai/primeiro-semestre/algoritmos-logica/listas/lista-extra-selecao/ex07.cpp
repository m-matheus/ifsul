#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int idade;

printf("Digite a sua idade: ");
scanf("%d", &idade);


if (idade >= 10 && idade <= 14) printf("Categoria: Infantil!\n");
else if (idade >= 15 && idade <= 17) printf("Categoria: Juvenil!\n");
else if (idade >= 18 && idade <= 25) printf("Categoria: Adulto!\n");


system("Pause");
return(0);
}

