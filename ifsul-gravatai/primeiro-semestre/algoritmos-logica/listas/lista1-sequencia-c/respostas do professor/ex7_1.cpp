#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
main()

{
   setlocale(LC_ALL, "Portuguese");
   // codigo
   int num;
   printf("Escreva um n�mero : ");
   scanf("%i",&num);
   printf("\nO antecessor �: %i",num-1);
   printf("\nO sucessor �: %i\n",num+1);
   
   system("PAUSE");
}

