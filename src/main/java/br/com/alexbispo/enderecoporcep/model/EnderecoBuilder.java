package br.com.alexbispo.enderecoporcep.model;

public class EnderecoBuilder {
	
	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	
	public EnderecoBuilder comCep(String cep){
		this.cep = cep;
		return this;
	}
	
	public EnderecoBuilder comLogradouro(String logradouro){
		this.logradouro = logradouro;
		return this;
	}
	
	public EnderecoBuilder comBairro(String bairro){
		this.bairro = bairro;
		return this;
	}
	
	public EnderecoBuilder comCidade(String cidade){
		this.cidade = cidade;
		return this;
	}
	
	public EnderecoBuilder comUf(String uf){
		this.uf = uf;
		return this;
	}
	
	public Endereco geraEndereco(){
		return new Endereco(cep, logradouro, bairro, cidade, uf);
	}

}
