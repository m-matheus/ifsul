#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
main()

{
   setlocale(LC_ALL, "Portuguese");
   // codigo
   float n1,n2,n3;
   float media;
   printf("Digite as idades: ");
   scanf("%f %f %f",&n1,&n2,&n3);
   media=(n1+n2+n3)/3;
   printf("\n A media é: %.2f\n",media);
   system("PAUSE");
}

