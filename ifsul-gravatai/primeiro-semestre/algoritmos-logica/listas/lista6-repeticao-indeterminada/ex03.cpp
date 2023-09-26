#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

float nt=0;
    
    do{
        system("cls");
        printf("\nInforme a nota do aluno: ");
        scanf("%f",&nt);
        if(nt<0||nt>10){
            printf("\nValor inváldo!");
            printf("\n\n");
            system("pause");
        }
        printf("\n\n");
    }while(nt>0||nt>10);


system("Pause");
return(0);
}

