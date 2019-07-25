package com.lithiumdigital.algamoney.api.erro;

public class ApiErro {
	
	private String mensagemUsuario;
	private String mensagemDesenvolvedor;
	
	public ApiErro(String mensagemUsuario, String mensagemDesenvolvedor) {
		
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	public String getMensagemUsuario() {
		return mensagemUsuario;
	}

	public void setMensagemUsuario(String mensagemUsuario) {
		this.mensagemUsuario = mensagemUsuario;
	}

	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}

	public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}
	
	
	
	

}
