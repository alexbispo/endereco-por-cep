package br.com.alexbispo.enderecoporcep.exception;

public class CepInvalidoException extends IllegalArgumentException {

	private static final long serialVersionUID = -439765013118056212L;

	public static final String CEP_INVALIDO = "CEP inválido";
	
	public CepInvalidoException(){
		super(CEP_INVALIDO);
	}

}
