#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

float c, a, qtca;

printf("Informe os dados para calcular a quantidade de caixas necess�rias:\n");

printf("Comprimento (em metros):\n");
scanf("%f", &c);

printf("Altura (em metros):\n");
scanf("%f", &a);

qtca = (c*a*4)/1.5;

printf("Ser� necess�rio %f caixas para colocar azuleijos em todas paredes (sem descontar portas/janelas).\n", qtca);

system("Pause");
return(0);
}

