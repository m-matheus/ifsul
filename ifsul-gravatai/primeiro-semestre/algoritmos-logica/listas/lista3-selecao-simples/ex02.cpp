#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int entrada;

printf("Digite um número: ");
scanf("%d", &entrada);
if (entrada>0) printf("É positivo!\n");
else printf("É negativo!\n");

system("Pause");
return(0);
}

