#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int a=80000, b=200000, anos=0;

while(a<b)
{
	a= a + (a * .03);
	b= b + (b * .015);
	anos = anos + 1;
	printf("População do país A: %d \n\n", a);
	printf("População do País B: %d \n\n", b);
	printf("%d Anos\n\n", anos);
}

system("Pause");
return(0);
}

