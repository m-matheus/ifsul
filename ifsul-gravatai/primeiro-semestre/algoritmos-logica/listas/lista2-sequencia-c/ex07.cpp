#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int a, sucessor, antecessor;

printf("Digite um número inteiro: ");
scanf("%d", &a);

sucessor = a + 1;
printf("O sucessor é: %d\n", sucessor);

antecessor = a - 1;
printf("O antecessor é: %d\n", antecessor);


system("Pause");
return(0);
}

