#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int entrada;

printf("Digite um n�mero inteiro: ");
scanf("%d", &entrada);
if (entrada>0) printf("� positivo!\n");
else if (entrada<0) printf("� negativo!\n");
else if (entrada==0) printf("O valor � zero.\n");

system("Pause");
return(0);
}

