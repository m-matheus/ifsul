#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
/* Meu primeiro programa em C
*/
main()
{
	setlocale(LC_ALL, "Portuguese");
	
	
	printf("Ol�, mundo!\n"); //printf para escrever coisas
	printf("Meu nome � Matheus de Moraes!\n"); // "\n"serve para pular linha ap�s texto
	
	
	system("Pause"); //system para chamar sistema operacional e pause para pausar no fim
	return(0);
}	
