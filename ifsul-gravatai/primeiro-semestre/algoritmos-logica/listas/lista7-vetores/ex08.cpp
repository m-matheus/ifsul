#include <stdio.h>
#include <locale.h>

int main() {
setlocale(LC_ALL, "Portuguese");

    int i, A[10];
    
	for (i=0; i<10; i++) 
	{
        A[i] = (i+1)*10;
    }
    
	printf("Vetor A: ");
    for (i=0; i<10; i++) 
	{
        printf("%d ", A[i]);
    }
    printf("\n");
    
	return 0;
}

