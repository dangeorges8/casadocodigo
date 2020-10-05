package br.com.casadocodigo.loja.infra;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeraSenha {
	
	public String gerarSenhaCriptografada(String senha) {
		
		String senhaCriptografada = new BCryptPasswordEncoder().encode(senha);
		return senhaCriptografada;
	}
}
