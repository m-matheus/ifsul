#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

float r, a;

printf("Digite o valor do raio do c�rculo (em m): \n");
scanf("%f", &r);

a = 3.14*r*r;

printf("O valor da �rea �: \n%f m�\n", a);

system("Pause");
return(0);
}

