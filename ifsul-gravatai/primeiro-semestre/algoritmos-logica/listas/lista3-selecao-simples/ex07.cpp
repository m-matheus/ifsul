#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

float salario, prestacao;

printf("Digite o seu s�lario, e o valor desejado para a presta��o: ");
scanf("%f %f", &salario, &prestacao);
if (prestacao>.2*salario) printf("Empr�stimo n�o pode ser concedido!\n");
else printf("Emprestimo concedido!\n");

system("Pause");
return(0);
}

