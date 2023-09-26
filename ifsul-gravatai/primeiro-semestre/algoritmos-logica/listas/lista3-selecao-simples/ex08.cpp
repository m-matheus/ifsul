#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

float n1, n2, n3;

printf("Digite as 3 notas do aluano: ");
scanf("%f %f %f", &n1, &n2, &n3);

if ((n1+n2+n3)/3>=7) printf("Aluno aprovado!\n");
else printf("Aluno reprovado!\n");

system("Pause");
return(0);
}

