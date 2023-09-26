#include <stdio.h>
#include <locale.h>

int main() {
setlocale(LC_ALL, "Portuguese");
    
	int i, cont=0;
    float num, media, soma=0;
    
	for (i=0; i<10; i++) 
	{
    	printf("Insira o %dº número: ", i+1);
        scanf("%f", &num);
        soma += num;
        if(num > media) 
		{
            cont++;
            printf("%dº número %.2f é maior que a média\n", i+1, num);
        }
    }
    media = soma / 10.0;
    printf("A média dos números é: %.2f\n", media);
    printf("Há %d valores maiores que a média.\n", cont);
    
	return 0;
}

