#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

char nome[100];
char senha[100];
    
    do{
        system("cls");
        printf("Escolha o seu usu�rio: \n");
        scanf("%s",nome);
        printf("Escolha uma senha: \n");
        scanf("%s",senha);
        if(strcmp(nome, senha) == 0){
            printf("\nSenha inv�lida! A senham precisa ser diferente do usu�rio.");
            printf("\n\n");
            system("Pause");
        }
        printf("\n\n");
    }while (strcmp(nome,senha) == 0);
    printf("Usu�rio criado com sucesso!\n\n");


system("Pause");
return(0);
}

