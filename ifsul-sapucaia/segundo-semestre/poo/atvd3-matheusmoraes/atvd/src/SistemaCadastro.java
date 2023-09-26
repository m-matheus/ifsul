import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCadastro {

	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		ArrayList<Usuario> listaUsuario = new ArrayList<>();
		Usuario novoUsuario = null;
		boolean running = true;
		int tipoUsuario;
		
		do {
			System.out.println("1 - Cadastrar novo usuário");
			System.out.println("2 - Login");
			int option = kb.nextInt();
			
			
			switch(option) {
			case 1: 
				String nomeUsuario = "";
				String emailUsuario = "";
				String senhaUsuario = "";
				
				
				
				System.out.println("Usuário:");
				nomeUsuario = kb.next();
				System.out.println("Email:");
				emailUsuario = kb.next();
				System.out.println("Senha:");
				senhaUsuario = kb.next();
				
				System.out.println("1 - Cadastrar aluno");
				System.out.println("2 - Cadastrar professor");
				
				
				tipoUsuario = kb.nextInt();
				if (tipoUsuario == 1) {
					novoUsuario = new Aluno();
					
					novoUsuario.setNome(nomeUsuario);
					novoUsuario.setEmail(emailUsuario);
					novoUsuario.setSenha(senhaUsuario);
					
					System.out.println("Qual o seu curso? ");
					((Aluno) novoUsuario).setCurso(kb.next());
					
					System.out.println("Qual o seu semestre? ");
					((Aluno) novoUsuario).setSemestre(kb.next());
					
				}
				else if (tipoUsuario == 2) {
					novoUsuario = new Professor();
					
					novoUsuario.setNome(nomeUsuario);
					novoUsuario.setEmail(emailUsuario);
					novoUsuario.setSenha(senhaUsuario);
					
					System.out.println("Digite a disciplina lecionada: ");
					((Professor) novoUsuario).setDisciplina(kb.next());
					
					System.out.println("Digite a sua formação: ");
					((Professor) novoUsuario).setFormacao(kb.next());
				}
				else {
					System.out.println("Número inválido!");
					continue;
				}
				
				
				listaUsuario.add(novoUsuario);
				
				System.out.println("Usuário cadastrado com sucesso!");
				break;
				
				
			case 2:
				System.out.println("Digite seu Email: ");
				String loginEmail = kb.next();
				System.out.println("Digite sua Senha: ");
				String loginSenha = kb.next();
				
				boolean logado = false;
				for (Usuario u : listaUsuario) {
					if (u.getEmail().equals(loginEmail) && (u.getSenha().equals(loginSenha))) {
						System.out.println("Bem-vindo " + u.getNome() + "!");
						logado = true;
					}
				}

				if (logado = false) {
					System.out.println("Usuário não encontrado!");
				}
				
			}
			
			System.out.println("Continuar = 0, Sair = 1");
			int exec = kb.nextInt();
			if (exec == 1) {
				running = false;
			}
			
		} while(running == true);
		
		kb.close();
	}

}
