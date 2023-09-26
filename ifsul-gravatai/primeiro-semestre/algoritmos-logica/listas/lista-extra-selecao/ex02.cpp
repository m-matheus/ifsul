#include <stdio.h>
#include <stdlib.h>
#include <locale.h>


main()
{
setlocale(LC_ALL, "Portuguese");

float h, hi;
char sexo;

printf("Digite a sua altura e o seu sexo (M ou F): ");
scanf("%f %c", &h, &sexo);

if(sexo == 'M' || 'm')
{
	hi = (72.7 * h) - 58; 
	printf("Seu peso ideal é: %.3f kg\n", hi);
}
else 
{
	hi = (62.1 * h) - 44.7;
	printf("Seu peso ideal é: %.3f kg\n", hi);	
}

system("Pause");
return(0);
}

