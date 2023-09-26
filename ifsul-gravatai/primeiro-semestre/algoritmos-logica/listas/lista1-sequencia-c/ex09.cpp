#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

main()
{
setlocale(LC_ALL, "Portuguese");

int nota1, nota2, nota3, soma, media;
char nome[15];


printf("Olá! \nDigite o seu nome, por favor: ");
scanf("%s", &nome);

printf("%s, me diga uma de suas notas: ", nome);
scanf("%d", nota1);

printf("Diga mais uma nota:");
scanf("%d", nota2);

printf("E agora, a última nota:");
scanf("%d", nota3);

soma = nota1 + nota2 + nota3;
media = soma / 3;

printf("A media de suas notas é: %media", media);

system("Pause");
return(0);
}

