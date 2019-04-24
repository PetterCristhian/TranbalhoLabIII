package br.com.david.facet.lab3;

public class Usuario {

	private int id;
	private String nomeCompleto;
	private String sexo;
	private int idade;
	private String cpf;
	private String rg;
	private String nacionalidade;
	private String estadoCivil;
	private String celular;
	private String telefoneFixo;
	private String dtNasc;
	private String endereco;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String string) {
		this.sexo = string;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
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

	@Override
	public String toString() {
		return "Id = " + id + "\n Nome Completo = " + nomeCompleto + "\n Sexo = " + sexo + "\n Idade = " + idade
				+ "\n Cpf = " + cpf + "\n Rg = " + rg + "\n Nacionalidade = " + nacionalidade + "\n EstadoCivil = "
				+ estadoCivil + "\n Celular = " + celular + "\n Telefone Fixo = " + telefoneFixo
				+ "\n Data de Nascimento = " + dtNasc + "\n Endereco = " + endereco + "\n Email = " + email;
	}

}
