
public class Aluno extends Usuario {
	protected String curso;
	protected String semestre;
	
	public Aluno() {
		super();
		curso = "";
		semestre = "";
	}

	public Aluno(String nome, String email, String senha, String curso, String semestre) {
		super(nome, email, senha);
		this.curso = curso;
		this.semestre = semestre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	
}
