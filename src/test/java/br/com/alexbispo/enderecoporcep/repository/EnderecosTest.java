package br.com.alexbispo.enderecoporcep.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.alexbispo.enderecoporcep.exception.CepInvalidoException;
import br.com.alexbispo.enderecoporcep.exception.EnderecoNaoEncontradoException;
import br.com.alexbispo.enderecoporcep.model.Endereco;

public class EnderecosTest {

	@Rule
	public ExpectedException exceptionEsperada = ExpectedException.none(); 
	
	@Test
	public void cepDeveEstarSemFormatacao() {
		exceptionEsperada.expect(CepInvalidoException.class);
		exceptionEsperada.expectMessage(CepInvalidoException.CEP_INVALIDO);
		Enderecos enderecos = new Enderecos();
		enderecos.porCep("12345-678");
	}
	
	@Test
	public void cepNaoDeveConterLetras() {
		exceptionEsperada.expect(CepInvalidoException.class);
		exceptionEsperada.expectMessage(CepInvalidoException.CEP_INVALIDO);
		Enderecos enderecos = new Enderecos();
		enderecos.porCep("1234567a");
	}
	
	@Test
	public void cepDeveConterNoMinimoOitoDigitos() {
		exceptionEsperada.expect(CepInvalidoException.class);
		exceptionEsperada.expectMessage(CepInvalidoException.CEP_INVALIDO);
		Enderecos enderecos = new Enderecos();
		enderecos.porCep("1234567");
	}
	
	@Test
	public void cepDeveConterNoMaximoOitoDigitos() {
		exceptionEsperada.expect(CepInvalidoException.class);
		exceptionEsperada.expectMessage(CepInvalidoException.CEP_INVALIDO);
		Enderecos enderecos = new Enderecos();
		enderecos.porCep("123456789");
	}
	
	@Test
	public void dadoUmCepValidoDeveRetornarEnderecoCorrespondente(){
		String cepValido = "12345678";
		Enderecos enderecos = new Enderecos();
		Endereco endereco = enderecos.porCep(cepValido);
		assertNotNull(endereco);
		assertEquals(cepValido, endereco.getCep());
	}
	
	@Test
	public void dadoUmCepValidoQueNaoExistaEnderecoDeveSubstituirUmDigitoDaDireitaParaEsquerdaPorZeroAteEncontrarEndereco() {
		String cepValido = "12345679";
		String cepCorreto = "12340000";
		
		Enderecos enderecos = new Enderecos();
		Endereco endereco = enderecos.porCep(cepValido);
		assertNotNull(endereco);
		assertEquals(cepCorreto, endereco.getCep());
	}
	
	@Test
	public void deveRetornarUmaMensagemSeNaoEncontrarEndereco(){
		exceptionEsperada.expect(EnderecoNaoEncontradoException.class);
		exceptionEsperada.expectMessage(EnderecoNaoEncontradoException.ENDERECO_NAO_ENCONTRADO);
		Enderecos enderecos = new Enderecos();
		enderecos.porCep("12300000");
	}

}
