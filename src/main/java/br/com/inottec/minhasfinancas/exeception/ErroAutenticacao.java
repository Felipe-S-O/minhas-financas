package br.com.inottec.minhasfinancas.exeception;

public class ErroAutenticacao extends RuntimeException{
	
	public ErroAutenticacao (String mensagem) {
		super(mensagem);
	}

}
