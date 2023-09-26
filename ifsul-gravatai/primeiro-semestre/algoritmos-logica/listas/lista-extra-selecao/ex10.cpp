#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int destino, modo;
	float tot;

	printf("Digite o código do seu destino: \n");
	printf("1 - Região Norte\n2 - Região Nordeste\n3 - Região Centro-Oeste\n4 - Região Sul \n\n");
	scanf("%d", &destino);

	printf("\nSelecione o tipo de passagem: \n");
	printf("1 - Somente ida\n2 - Ida e volta \n\n");
	scanf("%d", &modo);
	
	switch(destino){
		case 1:
			if(modo == 1) {
				tot = 500;
			}
			else {
				tot = 900;
			}
		break;
		case 2:
			if(modo == 1) {
				tot = 350;
			}
			else {
				tot = 650;
			}
		break;
		case 3:
			if(modo == 1) {
				tot = 350;
			}
			else {
				tot = 600;
			}
		break;
		case 4:
			if(modo == 1) {
				tot = 300;
			}
			else {
				tot = 550;
			}
		break;
	}
	
	printf("\nValor total da passagem: R$ %.2f \n", tot);

system("Pause");
return(0);
}

