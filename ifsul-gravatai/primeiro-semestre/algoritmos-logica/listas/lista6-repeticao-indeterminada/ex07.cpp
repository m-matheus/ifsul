#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int a, b, anos; 
float txa, txb;

printf("Digite o valor da popula��o do pa�s A: ");
scanf("%d", &a);
printf("Agora digite a taxa de crescimento do pa�s A (em %%): ");
scanf("%f", &txa);


printf("Digite o valor da popula��o do pa�s B: ");
scanf("%d", &b);
printf("Agora digite a taxa de crescimento do pa�s B (em %%): ");
scanf("%f", &txb);

do
{
	a= a + (a * (txa/100));
	b= b + (b * (txb/100));
	anos = anos + 1;
	printf("Popula��o do pa�s A: %d \n\n", a);
	printf("Popula��o do Pa�s B: %d \n\n", b);
	printf("%d Anos\n\n", anos);
} while(a<b);

system("Pause");
return(0);
}

