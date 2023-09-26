#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int a, b, soma, div;

printf("Digite dois números inteiros: \n");
scanf("%d%d", &a, &b);

soma = (a*a) + (b*b); 
div = a/b;

printf("A soma do quadrado dos números é: %d\n", soma);
printf("E a divisão dos seus resultados é: %d\n", div);

system("Pause");
return(0);
}

