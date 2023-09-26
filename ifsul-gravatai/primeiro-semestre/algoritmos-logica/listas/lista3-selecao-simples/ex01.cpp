#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int entrada;

printf("Digite um número: ");
scanf("%d", &entrada);
if (entrada %2==0) printf("É par!\n");
else printf("É impar!\n");

system("Pause");
return(0);
}

