#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int a, quadrado;

printf("Digite um n�mero inteiro: ");
scanf("%d", &a);

quadrado = a * a;
printf("O quadrado do n�mero �: %d\n", quadrado);

system("Pause");
return(0);
}


