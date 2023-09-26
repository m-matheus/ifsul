#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int conv;
float valor, calc;

printf("Digite o valor para conversão\n");
scanf("%f", &valor);
printf("\nDigite para qual moeda deseja converter:\n\n1- Libra Esterlina (R$ 3,80)\n2- Franco Suiço (R$ 1,85)\n3- Dólar Americano (R$ 2,43)\n4- Marco Alemão (R$ 2,31)\n\n");
scanf("%d", &conv);

switch(conv){
	
	case 1: {
		calc = valor * 3.80;
		printf("\n£ %f \n\n", calc);
		break;
	}
	case 2: {
		calc = valor * 1.85;
		printf("\nSFr %f \n\n", calc);
		break;
	}
	case 3: {
		calc = valor * 2.43;
		printf("\nUS$ %f \n\n", calc);
		break;
	}
	case 4: {
		calc = valor * 2.31;
		printf("\nDEM %f \n\n", calc);
		break; 
	}
	
}


system("Pause");
return(0);
}

