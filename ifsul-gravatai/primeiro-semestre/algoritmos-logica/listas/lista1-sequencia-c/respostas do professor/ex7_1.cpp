#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
main()

{
   setlocale(LC_ALL, "Portuguese");
   // codigo
   int num;
   printf("Escreva um número : ");
   scanf("%i",&num);
   printf("\nO antecessor é: %i",num-1);
   printf("\nO sucessor é: %i\n",num+1);
   
   system("PAUSE");
}

