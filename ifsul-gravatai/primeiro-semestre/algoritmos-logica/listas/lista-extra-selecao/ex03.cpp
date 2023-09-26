#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>

main()
{
setlocale(LC_ALL, "Portuguese");

char nome[20], sexo, estadocivil;
int in1, in2, tempocasamento;

printf("Digite o seu nome: ");
gets (nome);

printf("Qual o seu sexo? Digite 1 para masculino ou 2 para feminino: ");
scanf("%d", &in1);

switch(in1) {
	case 1:
		sexo = 'M';
	break;
	case 2:
		sexo = 'F';
	break;
	default:
		printf("Desculpe, não entendi. Valor não encontrado!\n");
	break;
}

printf("Qual seu estado civil? Digite 1 para casado ou 2 para solteiro: ");
scanf("%d", &in2);

switch(in2) {
	case 1:
		estadocivil = 'C';
	break;
	case 2:
		estadocivil = 'S';
	break;
	default:
		printf("Desculpe, não entendi. Valor não encontrado!\n");
	break;	
}

if (sexo == 'F' && estadocivil == 'C')
{
	printf("Digite o tempo de casado(a) em anos: ");
	scanf("%d", &tempocasamento);
	printf("Obrigado pelas informações!\n");
}


system("PAUSE");
}

