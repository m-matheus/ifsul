#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int in, d, t;

printf("Digite um número inteiro positivo ou negativo: ");
scanf("%d", &in);

if(in>0)
{
	d = in * 2;
	printf("%d\n", d);
}
else
{
	t = in * 3;
	printf("%d\n", t);
};

system("Pause");
return(0);
}

