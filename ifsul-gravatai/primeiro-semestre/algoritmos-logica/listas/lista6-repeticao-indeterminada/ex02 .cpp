#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int num=121;

do
{
	printf("%d \n", num);
	num= num +3;
}

while (num >= 121 && num <= 201);

system("Pause");
return(0);
}

