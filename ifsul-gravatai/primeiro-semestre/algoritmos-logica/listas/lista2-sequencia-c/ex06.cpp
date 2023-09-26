#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int n, a, b, c, d, e, f, g, h, i, j;

printf("Digite um número inteiro: \n");
scanf("%d", &n);

a = n * 1;
b = n * 2;
c = n * 3;
d = n * 4;
e = n * 5;
f = n * 6;
g = n * 7;
h = n * 8;
i = n * 9;
j = n * 10;

printf("A tabuada do número escolhido é: \n%d \n%d \n%d \n%d \n%d \n%d \n%d \n%d \n%d \n%d\n ", a, b, c, d, e, f, g, h, i, j);


system("Pause");
return(0);
}

