#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int a, b, soma, div;

printf("Digite dois n�meros inteiros: \n");
scanf("%d%d", &a, &b);

soma = (a*a) + (b*b); 
div = a/b;

printf("A soma do quadrado dos n�meros �: %d\n", soma);
printf("E a divis�o dos seus resultados �: %d\n", div);

system("Pause");
return(0);
}

