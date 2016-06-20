package br.com.alexbispo.enderecoporcep.exception;

public class EnderecoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 6749275079698929779L;
	
	public static final String ENDERECO_NAO_ENCONTRADO = "Endereco não encontrado";
	
	public EnderecoNaoEncontradoException(){
		super(ENDERECO_NAO_ENCONTRADO);
	}

}
