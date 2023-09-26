#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>
main()

{
   setlocale(LC_ALL, "Portuguese");
   // codigo
   char nome[15],i,tam;
   printf("Digite um nome: ");
   gets(nome);
   
   tam=strlen(nome); //guarda o tamanho digitado do meu string
   
   for (i=0;i<=tam;i++)
        printf("\n %c",nome[i]);
   for (i=tam;i>=0;i--)
        printf("%c",nome[i]);
