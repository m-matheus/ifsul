#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

char nome[20],sexo,est;
int idade;
float sal=-1;
   		 
do {
	printf("Digite o seu nome: \n");
	scanf("%s",&nome);
	fflush(stdin);
}while (strlen(nome)<3);
   				   		
do {
	printf("\nDigite a sua idade: \n");
	scanf("%d",&idade);
}while (idade<0 || idade>150);
	
while(sal<=0) {
	printf("\nDigite o seu salário: \n");
	scanf("%f",&sal);
}	

fflush(stdin);
   		
do {
   	printf("\nDigite o seu sexo: masculino[m] ou feminino[f]: \n");
	scanf("%c",&sexo);
	fflush(stdin);
} 	while (sexo!='f' && sexo!='m' && sexo!='F' && sexo!='M');
  			
do {
   	printf("\nDigite o seu estado civil: solteiro(s), casado(c), viuvo(v), divorciado(d): \n");
	scanf("%c",&est);
	fflush(stdin);
	} while (est!='s' && est!='c' && est!='v' && est!='d');
   		 		   		
printf("\n%s Possui %d anos",nome,idade);
printf("\nSalário: %.2f",sal);
printf("\nSexo: %c",sexo);
printf("\nEstado Civil: %c\n",est);

system("Pause");
return(0);
}

