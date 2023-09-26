#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
main()

{
   setlocale(LC_ALL, "Portuguese");
   // codigo
   int n1,n2,produto,soma;
   printf("Escreva os valores: \n");
   scanf("%i %i",&n1,&n2);
   produto=n1*n2;
   soma=n1+n2;
   printf("\nO produto é: %i\n",produto);
   printf("\nA soma é: %i\n",soma);
   system("PAUSE");
   
}

