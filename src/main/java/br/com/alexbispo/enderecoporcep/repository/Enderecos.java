package br.com.alexbispo.enderecoporcep.repository;

import java.util.HashMap;
import java.util.Map;

import br.com.alexbispo.enderecoporcep.exception.CepInvalidoException;
import br.com.alexbispo.enderecoporcep.exception.EnderecoNaoEncontradoException;
import br.com.alexbispo.enderecoporcep.model.Endereco;

public class Enderecos {
	
	public Endereco porCep(String cep){
		if(!cep.matches("^[0-9]{8}$")){
			throw new CepInvalidoException();
		}
		Map<String, Endereco> listaDeEnderecos = listarEnderecos();
		Endereco endereco = null;
		
		char[] charCep = cep.toCharArray();
		for(int i = charCep.length - 1; i >= 0; i--){
			endereco = listaDeEnderecos.get(cep);
			
			if(endereco != null){
				break;
			}
			
			charCep[i] = '0';
			cep = String.valueOf(charCep);
		}
		
		if(endereco == null){
			throw new EnderecoNaoEncontradoException();
		}
		
		return endereco;
	}
	
	private Map<String, Endereco> listarEnderecos(){
		Map<String, Endereco> listaDeEnderecos =  new HashMap<>();
		
		Endereco endereco = new Endereco("12345678", "Rua da Paz", "Jardim Felicidade", "São Paulo", "SP");
		listaDeEnderecos.put(endereco.getCep(), endereco);
		
		Endereco enderecoDois = new Endereco("12340000", "Rua do Bolo", "Jardim Confeiteiro", "São Paulo", "SP");
		listaDeEnderecos.put(enderecoDois.getCep(), enderecoDois);
		
		return listaDeEnderecos;
	}

}
