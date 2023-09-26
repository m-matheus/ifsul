#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int idade;

printf("Qual a sua idade? ");
scanf("%d", &idade);

if (idade <= 10) printf("O valor do plano para você é de: R$ 10,00 \n\n");
else if (idade > 10 && idade <= 29) printf("O valor do plano para você é de: R$ 60,00 \n\n");
else if (idade > 29 && idade <= 45) printf("O valor do plano para você é de: R$ 120,00 \n\n");
else if (idade > 45 && idade <= 59) printf("O valor do plano para você é de: R$ 150,00 \n\n");
else if (idade > 59 && idade <= 65) printf("O valor do plano para você é de: R$ 250,00 \n\n");
else if (idade > 59) printf("O valor do plano para você é de: R$ 400,00");

system("Pause");
return(0);
}

