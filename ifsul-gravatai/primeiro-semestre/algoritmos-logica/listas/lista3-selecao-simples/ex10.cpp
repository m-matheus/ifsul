#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int a, b, c;

printf("Digite dois números inteiros: ");
scanf("%d %d", &a, &b);

if (a==b)
{ c = a + b;
	printf("%d\n", c);
 } 

else
{ c = a * b;
	printf("%d\n", c);
}

system("Pause");
return(0);
}

