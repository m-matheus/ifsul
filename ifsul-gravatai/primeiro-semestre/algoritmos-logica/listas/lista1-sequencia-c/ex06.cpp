#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int a, b, idade;

printf("Digite o ano do seu nascimento (4 digitos): ");
scanf("%d", &a);

b = 2022;

idade = b - a;

printf("Essa é a sua idade: %d\n", idade);


system("Pause");
return(0);
}
