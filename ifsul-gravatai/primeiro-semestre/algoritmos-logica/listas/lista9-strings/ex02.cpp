#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>
main()

{
   setlocale(LC_ALL, "Portuguese");
   // codigo
   
      char nome[15];
      int i,j,cont;
      
      printf("Digite uma palavra: ");
      gets(nome);
      cont=strlen(nome); //contando o tam do string
      for (j=0;j<cont;j++){
     
      for (i=0;i<=j;i++)  
                printf("%c", nome[i]);
                printf("\n");
            }
     
   system("PAUSE");
}
