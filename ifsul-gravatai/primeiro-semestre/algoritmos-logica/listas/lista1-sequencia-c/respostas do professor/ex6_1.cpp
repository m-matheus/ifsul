#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
main()

{
   setlocale(LC_ALL, "Portuguese");
   // codigo
   float idade,ano;
   printf("Escreva o ano de nascimento (use 4 digitos): ");
   scanf("%f",&ano);
   idade=2020-ano;
   printf("\nA sua idade é: %.f\n",idade);
   system("PAUSE");
    }

