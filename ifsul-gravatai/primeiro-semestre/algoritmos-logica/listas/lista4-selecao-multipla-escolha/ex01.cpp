#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int valor, proc;

printf("Digite o valor do produto\n");
scanf("%d", &valor);
printf("\nDigite a op��o da proced�ncia:\n\n1- Sul\n2- Norte\n3- Leste\n4- Oeste\n5 � 6- Nordeste\n7,8,9- Sudeste\n10 at� 20- Centro-oeste\n25 at� 50- Nordeste\n\n");
scanf("%d", &proc);

switch(proc){
	
	case 1: {
		printf("R$ %d - Proced�ncia: Sul\n\n", valor);
		break;
	}
	case 2: {
		printf("R$ %d - Proced�ncia: Norte\n\n", valor);
		break;
	}
	case 3: {
		printf("R$ %d - Proced�ncia: Leste\n\n", valor);
		break;
	}
	case 4: {
		printf("R$ %d - Proced�ncia: Oeste\n\n", valor);
		break;
	}
	case 5 ... 6: {
		printf("R$ %d - Proced�ncia: Nordeste\n\n", valor);
		break;
	}
	case 7 ... 9: {
		printf("R$ %d - Proced�ncia: Sudeste\n\n", valor);
		break;
	}
	case 10 ... 20: {
		printf("R$ %d - Proced�ncia: Centro-oeste\n\n", valor);
		break;
	}
	case 25 ... 50: {
		printf("R$ %d - Proced�ncia: Nordeste\n\n", valor);
		break;
	default: {
		printf("R$ %d - Proced�ncia: Importado\n\n", valor);
		break;
	}
	}
	
}


system("Pause");
return(0);
}

