#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int a, sucessor, antecessor;

printf("Digite um n�mero inteiro: ");
scanf("%d", &a);

sucessor = a + 1;
printf("O sucessor �: %d\n", sucessor);

antecessor = a - 1;
printf("O antecessor �: %d\n", antecessor);


system("Pause");
return(0);
}

