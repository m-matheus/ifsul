#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int entrada;

printf("Digite um n�mero: ");
scanf("%d", &entrada);
if (entrada %2==0) printf("� par!\n");
else printf("� impar!\n");

system("Pause");
return(0);
}

