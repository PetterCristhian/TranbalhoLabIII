package user;

public class Usuario {

	private String nomeCompleto;
	private String cpf;
	private String dtNasc;
	private String endereco;
	private String nomeMae;
	private String nomePai;
	private String celular;
	private String telefoneFixo;
	private String email;
	private String curso;
	private int matricula;
	private String nomeCurso;
	
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	
	/*@Override
	public String toString() {
		return "Id = " + id + "\n Nome Completo = " + nomeCompleto + "\n Sexo = " + sexo + "\n Idade = " + idade
				+ "\n Cpf = " + cpf + "\n Rg = " + rg + "\n Nacionalidade = " + nacionalidade + "\n EstadoCivil = "
				+ estadoCivil + "\n Celular = " + celular + "\n Telefone Fixo = " + telefoneFixo
				+ "\n Data de Nascimento = " + dtNasc + "\n Endereco = " + endereco + "\n Email = " + email;
	}*/

	

}
