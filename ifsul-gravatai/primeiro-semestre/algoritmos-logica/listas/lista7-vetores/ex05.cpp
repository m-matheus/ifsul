#include <stdio.h>
#include <locale.h>

int main() {
setlocale(LC_ALL, "Portuguese");
    
	int i, cont=0;
    float num, media, soma=0;
    
	for (i=0; i<10; i++) 
	{
    	printf("Insira o %d� n�mero: ", i+1);
        scanf("%f", &num);
        soma += num;
        if(num > media) 
		{
            cont++;
            printf("%d� n�mero %.2f � maior que a m�dia\n", i+1, num);
        }
    }
    media = soma / 10.0;
    printf("A m�dia dos n�meros �: %.2f\n", media);
    printf("H� %d valores maiores que a m�dia.\n", cont);
    
	return 0;
}

