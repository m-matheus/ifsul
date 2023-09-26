#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int idade, doa=0, ndoa=0, cont=0;
float peso;
char jejum;

do {
	printf("Digite a sua idade: \n");
	scanf("%d", &idade);
	
	printf("Digite o seu peso: \n");
	scanf("%f", &peso);
	
	printf("Está de jejum? [S ou N]: \n");
	scanf("%s", &jejum);
	
	if(idade>=18 && idade<=67 && peso>=50 && jejum=='s')
	{
		doa++;
		printf("Apto a doar!\n\n");
	}
	else {
		ndoa++;
		printf("Desculpe! Você não pode doar.\n\n");
	}
	
}	while(cont<=10);

printf("Total de doadores: %d.", doa);
printf("Total de não doadores: %d", ndoa);

system("Pause");
return(0);
}

