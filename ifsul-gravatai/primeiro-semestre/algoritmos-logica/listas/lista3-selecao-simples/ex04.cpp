#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int entrada;

printf("Digite um n�mero inteiro: ");
scanf("%d", &entrada);
if (entrada>20) printf("� maior que 20!\n");
else printf("� menor que 20!\n");

system("Pause");
return(0);
}

