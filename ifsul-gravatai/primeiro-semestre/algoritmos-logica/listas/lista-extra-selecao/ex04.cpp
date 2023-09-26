#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>


main()
{
setlocale(LC_ALL, "Portuguese");

float peso, altura, imc;

printf("Digite o seu peso: ");
scanf("%f", &peso);

printf("Digite a sua altura: ");
scanf("%f", &altura);

imc = peso/pow(altura,2);

if (imc < 18.5) printf("Abaixo do peso!\n");
else if (imc > 18.5 && imc < 25) printf ("Peso normal!\n");
else if (imc > 25 && imc < 30) printf("Acima do peso!\n");
else if (imc > 30) printf("Obeso!\n");





system("Pause");
return(0);
}

