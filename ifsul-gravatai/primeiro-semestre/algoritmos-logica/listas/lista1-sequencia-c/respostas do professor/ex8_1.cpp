#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
main()

{
   setlocale(LC_ALL, "Portuguese");
   // codigo
   int num,quadrado;
   printf("Escreva um número : ");
   scanf("%i",&num);
   quadrado=num*num;
   printf("\nO quadrado de %i é: %i\n",num,quadrado);
   system("PAUSE");
}

