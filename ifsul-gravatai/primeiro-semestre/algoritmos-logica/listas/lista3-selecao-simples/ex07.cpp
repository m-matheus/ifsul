#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

float salario, prestacao;

printf("Digite o seu sálario, e o valor desejado para a prestação: ");
scanf("%f %f", &salario, &prestacao);
if (prestacao>.2*salario) printf("Empréstimo não pode ser concedido!\n");
else printf("Emprestimo concedido!\n");

system("Pause");
return(0);
}

