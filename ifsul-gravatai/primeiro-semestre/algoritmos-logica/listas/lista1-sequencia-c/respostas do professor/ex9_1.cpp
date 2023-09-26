#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
main()

{
   setlocale(LC_ALL, "Portuguese");
   // codigo
   int n1,n2,n3,soma;
   char nome[15];
   scanf("%i %i",&n1,&n2);
   scanf("%s",&nome);
   soma=(n1+n2+n3)/3;
   printf("\n A media é: %i\n",soma);
   printf("Seu nome é: %s\n",nome);
   system("PAUSE");
}


