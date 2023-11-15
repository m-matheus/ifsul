import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        double N = 0;
        double somaTurma = 0;
        double mediaTurma = 0;
        int alunosAprovados = 0;
        double somaTotal = 0;
        double mediaTotal = 0;
        // 3 turmas de 10 alunos = 30 alunos no total

        for (int i = 0; i < 3; i++) { // turmas
            for (int j = 0; j < 10; j++) { // notas dos alunos das turmas
                N = input.nextDouble();
                // soma a nota de cada aluno da turma
                somaTurma += N;
                // verifica se o aluno tirou mais de 7
                if (N >= 7) {
                    alunosAprovados++;
                }
                // soma de todas turmas
                somaTotal += N;
            }
            // media de cada turma
            mediaTurma = somaTurma / 10.0;
            System.out.printf("Média da Turma %d: %.1f\n", i + 1, mediaTurma);
            // zera a soma da turma para o proximo loop
            somaTurma = 0;
        }
        System.out.printf("Alunos aprovados: %d\n", alunosAprovados);
        // calculando media de todas turmas
        mediaTotal = somaTotal / 30;
        System.out.printf("Média do nível B2: %.1f\n", mediaTotal);

        input.close();
    }
}
/* 
10,0 9,5 10,0 9,0 9,8 8,5 7,0 6,9 6,2 7,5
8,5 6,9 6,3 2,1 7,0 8,5 6,7 4,9 7,8 5,6
6,9 7,5 10,0 5,9 8,6 4,9 7,8 9,8 9,9 8,8

*/