#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int num=0;

while (num<=20)
{
	printf("%d ", num);
	num++;
}

system("Pause");
return(0);
}

