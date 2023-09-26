#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int entrada;

printf("Digite um número inteiro: ");
scanf("%d", &entrada);
if (entrada>0) printf("É positivo!\n");
else if (entrada<0) printf("É negativo!\n");
else if (entrada==0) printf("O valor é zero.\n");

system("Pause");
return(0);
}

