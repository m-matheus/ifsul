#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int f, c;

printf("Informe a temperatura em Fahrenheit: \n");
scanf("%d", &f);

c = (5*(f-32))/9;


printf("A temperatura em centígrados é: \n%d °C \n", c);


system("Pause");
return(0);
}

