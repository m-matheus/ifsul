#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <conio.h>
#include <string.h>
#include <math.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int num;
float maior=-999999, menor=999999, somP=0, somaI=0, impar, maior50, maior20, tot20, tot50_150=0;
float cont50_150=0, total=0, conttot=0;
   
   do 
   {
   		printf("Digite um número: ");
   		scanf("%d", &num);
   		if(num<0) 
		   break;
   		if(num>maior) maior=num;
   		if(num<menor) menor=num;
   		if(num%2==0) somP=somP+num;
   		if(num%2!=0) {somaI=somaI+num;  impar++;}
   		if(num>50) maior50++;
   		if(num>20) tot20++;
   		if(num%2==0 && num>=50 && num<=150) {tot50_150=tot50_150+num;  cont50_150++;}
   		total=total+num;
   		conttot++;
   }
   		while(num>=0);
   printf("O maior número? %.f\n", maior);
   printf("O menor número? %.f\n", menor);
   printf("A soma dos valores pares? %.f\n", somP);
   printf("A média dos valores impares? %.2f\n", somaI/impar);
   printf("A quantidade de valores maiores que 50? %.2f\n", maior50);
   printf("O percentual de valores maiores que 20? %.2f %%\n", (tot20/conttot)*100);
   printf("A média de valores pares entre 50 e 150? %.2f\n", tot50_150/cont50_150);
	printf("O total de valores? %.2f\n", total);	

system("Pause");
return(0);
}

