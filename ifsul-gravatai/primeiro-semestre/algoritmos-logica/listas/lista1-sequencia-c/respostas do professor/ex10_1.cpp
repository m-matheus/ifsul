#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
main()

{
   setlocale(LC_ALL, "Portuguese");
   // codigo
   float num,meio,terco;
   printf("Escreva um n�mero : ");
   scanf("%f",&num);
   meio=num/2;
   terco=num/3;
   printf("\nA metade de %.2f �: %.2f\n",num,meio);
   printf("\nUm ter�o de %.2f �: %.2f\n",num,terco);
   system("PAUSE");
}

