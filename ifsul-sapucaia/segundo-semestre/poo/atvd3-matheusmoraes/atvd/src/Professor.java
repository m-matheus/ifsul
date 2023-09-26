
public class Professor extends Usuario {
	protected String disciplina;
	protected String formacao;
	public Professor() {
		super();
		disciplina = "";
		formacao = "";
	}

	
	
	public Professor(String nome, String email, String senha, String disciplina, String formacao) {
		super(nome, email, senha);
		this.disciplina = disciplina;
		this.formacao = formacao;
	}



	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	
}
