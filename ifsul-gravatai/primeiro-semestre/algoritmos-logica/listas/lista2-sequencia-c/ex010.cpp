#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

float d, t, vm;

printf("Digite a dist�ncia percorrida (em km): \n");
scanf("%f", &d);

printf("Digite o tempo utilizado para percorrer essa dist�ncia (em horas): \n");
scanf("%f", &t);

vm = d/t;

printf("A velocidade m�dia foi de: %f km/h\n", vm);

system("Pause");
return(0);
}

