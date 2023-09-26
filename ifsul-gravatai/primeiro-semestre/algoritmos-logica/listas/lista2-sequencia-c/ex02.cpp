#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int a, b;

printf("Digite o valor de A: \n");
scanf("%d", &a);

printf("Digite o valor de B: \n"); 
scanf("%d", &b);

a = a + b;
b = a - b;
a = a - b;

printf("Alterando os valores entre si temos: \n");
printf("O valor de A é: %d \n", a);
printf("O valor de B é: %d \n", b);

system("Pause");
return(0);
}

