public class Main {

    public static void zerarMatriz(String[][] m) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = "";
            }
        }
    }

    public static void listar(String[][] m) {
        System.out.println("|----------------------------------------------------|");
        System.out.println("| Código | Descricao | Preço | Quantidade em estoque |");
        for (int i = 0; i < 10; i++) {
            if (!m[i][0].equals("")) {
                System.out.printf("| %s | %s | %s | %s |\n", m[i][0], m[i][1], m[i][2], m[i][3]);
            }
        }
        System.out.println("|----------------------------------------------------|");
    }

    public static boolean excluir(String[][] m, String codigo) {
        for (int i = 0; i < 10; i++) {
            if (m[i][0].equals(codigo)) {
                for (int j = 0; j < 4; j++) {
                    m[i][j] = "";
                }
                return true;
            }
        }
        return false;
    }

    public static int cadastrar(String[][] m, String codigo, String descricao, String preco, String qtde) {
        if (Double.parseDouble(preco) <= 0) {
            return -4; // erro: preco <=0;
        }

        if (Integer.parseInt(qtde) < 0) {
            return -5; // erro: quantidade < 0;
        }

        for (int i = 0; i < 10; i++) {
            if (m[i][0].equals(codigo)) {
                return -2; // erro: código já existe
            }
            if (m[i][1].equals(descricao)) {
                return -3; // erro: produto já cadastrado
            }
            if (m[i][0] == "") {
                m[i][0] = codigo;
                m[i][1] = descricao;
                m[i][2] = preco;
                m[i][3] = qtde;
                return 0; // produto cadastrou com sucesso
            }
        }
        return -1; // matriz cheia
    }

    public static void imprimirCadastrar(String[][] m, String codigo, String descricao, String preco, String qtde) {
        switch (cadastrar(m, codigo, descricao, preco, qtde)) {
            case 0: {
                System.out.println("Produto cadastrado com sucesso.");
                break;
            }
            case -1: {
                System.out.println("ERRO: memória cheia.");
                break;
            }
            case -2: {
                System.out.println("ERRO: código já existe.");
                break;
            }
            case -3: {
                System.out.println("ERRO: Produto já cadastrado.");
                break;
            }
            case -4: {
                System.out.println("ERRO: Preço inválido.");
                break;
            }
            case -5: {
                System.out.println("ERRO: Quantidade inválida.");
                break;
            }
            default: {
                System.out.println("ERRO INESPERADO!");
            }
        }
    }

    public static void main(String[] args) {

        String[][] matriz = new String[10][4];
        zerarMatriz(matriz);

        imprimirCadastrar(matriz, "1", "batata", "4.00", "300");
        imprimirCadastrar(matriz, "2", "pao", "1.00", "5");
        listar(matriz);

        if (excluir(matriz, "1") == true) {
            System.out.println("Produto excluído com sucesso");
        } else {
            System.out.println("Produto não encontrado");
        }
        listar(matriz);
    }

}