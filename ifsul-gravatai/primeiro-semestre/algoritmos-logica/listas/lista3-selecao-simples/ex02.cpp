#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int entrada;

printf("Digite um n�mero: ");
scanf("%d", &entrada);
if (entrada>0) printf("� positivo!\n");
else printf("� negativo!\n");

system("Pause");
return(0);
}

