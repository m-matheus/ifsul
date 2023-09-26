#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int a, quadrado;

printf("Digite um número inteiro: ");
scanf("%d", &a);

quadrado = a * a;
printf("O quadrado do número é: %d\n", quadrado);

system("Pause");
return(0);
}


