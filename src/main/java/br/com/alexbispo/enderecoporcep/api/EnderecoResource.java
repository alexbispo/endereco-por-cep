package br.com.alexbispo.enderecoporcep.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alexbispo.enderecoporcep.exception.CepInvalidoException;
import br.com.alexbispo.enderecoporcep.exception.EnderecoNaoEncontradoException;
import br.com.alexbispo.enderecoporcep.model.Endereco;
import br.com.alexbispo.enderecoporcep.repository.Enderecos;

@Path("/enderecos/{cep}")
public class EnderecoResource {
	
	private static final String APPLICATION_JSON_CHARSET_UTF_8 = MediaType.APPLICATION_JSON + ";charset=utf-8"; 

	@GET
	@Produces({ APPLICATION_JSON_CHARSET_UTF_8 })
	public Endereco getJSON(@PathParam("cep") String cep) {
		try {
			Enderecos enderecos = new Enderecos();
			Endereco endereco = enderecos.porCep(cep);

			return endereco;
		} catch (CepInvalidoException cie) {
			throw new WebApplicationException(construirRespostaParaExcption(cie.getMessage()));
		} catch (EnderecoNaoEncontradoException enee) {
			throw new WebApplicationException(construirRespostaParaExcption(enee.getMessage()));
		}
	}
	
	private Response construirRespostaParaExcption(String msg){
		return Response.status(Response.Status.BAD_REQUEST).entity(msg).type(APPLICATION_JSON_CHARSET_UTF_8).build();
	}
}
