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

printf("Digite o valor da população do país A: ");
scanf("%d", &a);
printf("Agora digite a taxa de crescimento do país A (em %%): ");
scanf("%f", &txa);


printf("Digite o valor da população do país B: ");
scanf("%d", &b);
printf("Agora digite a taxa de crescimento do país B (em %%): ");
scanf("%f", &txb);

do
{
	a= a + (a * (txa/100));
	b= b + (b * (txb/100));
	anos = anos + 1;
	printf("População do país A: %d \n\n", a);
	printf("População do País B: %d \n\n", b);
	printf("%d Anos\n\n", anos);
} while(a<b);

system("Pause");
return(0);
}

