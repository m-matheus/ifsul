#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
main()

{
   setlocale(LC_ALL, "Portuguese");
   // codigo
   int num,quadrado;
   printf("Escreva um n�mero : ");
   scanf("%i",&num);
   quadrado=num*num;
   printf("\nO quadrado de %i �: %i\n",num,quadrado);
   system("PAUSE");
}

