#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

float r, a;

printf("Digite o valor do raio do círculo (em m): \n");
scanf("%f", &r);

a = 3.14*r*r;

printf("O valor da área é: \n%f m²\n", a);

system("Pause");
return(0);
}

