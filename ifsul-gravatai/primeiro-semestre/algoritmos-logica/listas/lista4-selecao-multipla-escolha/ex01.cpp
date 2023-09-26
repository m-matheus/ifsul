#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int valor, proc;

printf("Digite o valor do produto\n");
scanf("%d", &valor);
printf("\nDigite a opção da procedência:\n\n1- Sul\n2- Norte\n3- Leste\n4- Oeste\n5 à 6- Nordeste\n7,8,9- Sudeste\n10 até 20- Centro-oeste\n25 até 50- Nordeste\n\n");
scanf("%d", &proc);

switch(proc){
	
	case 1: {
		printf("R$ %d - Procedência: Sul\n\n", valor);
		break;
	}
	case 2: {
		printf("R$ %d - Procedência: Norte\n\n", valor);
		break;
	}
	case 3: {
		printf("R$ %d - Procedência: Leste\n\n", valor);
		break;
	}
	case 4: {
		printf("R$ %d - Procedência: Oeste\n\n", valor);
		break;
	}
	case 5 ... 6: {
		printf("R$ %d - Procedência: Nordeste\n\n", valor);
		break;
	}
	case 7 ... 9: {
		printf("R$ %d - Procedência: Sudeste\n\n", valor);
		break;
	}
	case 10 ... 20: {
		printf("R$ %d - Procedência: Centro-oeste\n\n", valor);
		break;
	}
	case 25 ... 50: {
		printf("R$ %d - Procedência: Nordeste\n\n", valor);
		break;
	default: {
		printf("R$ %d - Procedência: Importado\n\n", valor);
		break;
	}
	}
	
}


system("Pause");
return(0);
}

