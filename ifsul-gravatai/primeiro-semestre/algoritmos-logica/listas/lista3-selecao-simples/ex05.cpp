#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int entrada;

printf("Digite um número inteiro: ");
scanf("%d", &entrada);
if (entrada>20) printf("É maior que 20!\n");
else if (entrada<20) printf("É menor que 20!\n");
else if (entrada==20) printf("É igual a 20.\n");

system("Pause");
return(0);
}

