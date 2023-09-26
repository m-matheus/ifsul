#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
/* Meu primeiro programa em C
*/
main()
{
	setlocale(LC_ALL, "Portuguese");
	
	
	printf("Olá, mundo!\n"); //printf para escrever coisas
	printf("Meu nome é Matheus de Moraes!\n"); // "\n"serve para pular linha após texto
	
	
	system("Pause"); //system para chamar sistema operacional e pause para pausar no fim
	return(0);
}	
