#include <stdio.h>
#include <locale.h>

int main() {
setlocale(LC_ALL, "Portuguese");

int m[5][5];
int i, j;

for(i=0; i<5; i++)
	{
		for(j=0; j<5; j++)
			{
				scanf("%d", &m[i][j]);
				if(m[i][j] < 0) 
				{
					m[i][j] = 0;
				}
			}
	}
	
for(i=0; i<5; i++)
	{
		for(j=0; j<5; j++)
			{
				printf("%d \t ", m[i][j]);
			}
			printf("\n");
	}
	
	return 0;
}

