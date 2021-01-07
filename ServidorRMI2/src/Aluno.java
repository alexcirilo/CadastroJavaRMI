import java.io.Serializable;

public class Aluno implements Serializable {

	public String nome;
    public String sobrenome;
    public String email;
    public String residencia;
    public String formacaoAcademica;
    public String habilidades;
    public String experienciaProfissional;
    
    
    
	public Aluno(String nome, String sobrenome, String email, String residencia, String formacaoAcademica,
			String habilidades, String experienciaProfissional) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.residencia = residencia;
		this.formacaoAcademica = formacaoAcademica;
		this.habilidades = habilidades;
		this.experienciaProfissional = experienciaProfissional;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResidencia() {
		return residencia;
	}
	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}
	public String getFormacaoAcademica() {
		return formacaoAcademica;
	}
	public void setFormacaoAcademica(String formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}
	public String getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}
	public String getExperienciaProfissional() {
		return experienciaProfissional;
	}
	public void setExperienciaProfissional(String experienciaProfissional) {
		this.experienciaProfissional = experienciaProfissional;
	}
    

    
}
