#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int horastrab, valordahora, salario;

printf("Digite a quantidade de horas trabalhadas: \n");
scanf("%d", &horastrab);

printf("Digite o valor da hora trabalhada: \n");
scanf("%d", &valordahora);

salario = horastrab * valordahora;

printf("O valor do salário é: R$ %d \n", salario);


system("Pause");
return(0);
}

