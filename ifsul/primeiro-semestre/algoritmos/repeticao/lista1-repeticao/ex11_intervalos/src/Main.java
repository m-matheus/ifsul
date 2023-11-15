import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        String nome = input.nextLine();

        for (int i = 0; i < nome.replace(" ", "").length(); i++) {
            System.out.println(nome);
        }

        input.close();
    }
}
