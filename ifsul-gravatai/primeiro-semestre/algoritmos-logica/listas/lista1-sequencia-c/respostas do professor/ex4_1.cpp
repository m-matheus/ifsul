#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
main()

{
   setlocale(LC_ALL, "Portuguese");
   // codigo
  
   int n1,n2,produto;
   printf("Escreva os valores: \n");
   scanf("%i %i",&n1,&n2);
   produto=n1*n2;
   printf("\nO produto é: %i\n",produto);
   system("PAUSE");
}

