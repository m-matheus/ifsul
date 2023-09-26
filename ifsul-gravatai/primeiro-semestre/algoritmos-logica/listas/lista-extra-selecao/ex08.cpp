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

printf("Qual a sua idade? ");
scanf("%d", &idade);

if (idade >= 18 && idade <= 67) printf("Você pode doar sangue. \n\n");
else printf("Você não pode doar sangue! \n\n");

system("Pause");
return(0);
}

