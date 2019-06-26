package com.andersonfonseka.caffeine.componentes.impl.compostos;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.IAcesso;
import com.andersonfonseka.caffeine.IBotao;
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IEntradaEmail;
import com.andersonfonseka.caffeine.IEntradaSenha;
import com.andersonfonseka.caffeine.IPagina;
import com.andersonfonseka.caffeine.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.Resposta;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Botao;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Conteiner;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaEmail;
import com.andersonfonseka.caffeine.componentes.impl.basicos.EntradaSenha;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper=false)
public class Acesso extends Conteiner implements IAcesso, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private transient MensagemUtil mensagemUtil = new MensagemUtil();
	
	@Inject
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	IComponenteFabrica componenteFabrica;
	
	private transient IEntradaEmail email;

	private transient IEntradaSenha senha;
	
	private transient IBotao botaoAcesso;
	
	private transient IPagina pagina;
	
	private Class<? extends IPagina> paginaDestino;
	
	private  Map<String, String> usuarios;
	
	public Acesso(IComponenteFabrica componenteFabrica, IPagina pagina, Map<String, String> usuarios, Class<? extends IPagina> paginaDestino) {
		
		super(3);
		this.componenteFabrica = componenteFabrica;
		this.pagina = pagina;
		this.paginaDestino = paginaDestino;
		this.usuarios = usuarios;
		post();
	
	}
	
	@PostConstruct
	public void post() {

		email = new EntradaEmail.Builder("Email", true).build();

		senha = new EntradaSenha.Builder("Senha", true).build();

		botaoAcesso = new Botao.Builder("Conectar", new AcaoAbs(pagina) {
			public IResposta execute() {

				IResposta pageResponse = new Resposta.Builder().build();

				 if (usuarios.containsKey(email.getValor()) && 
						 usuarios.get(email.getValor()).equals(senha.getValor())) {
					pageResponse.setPageUrl(paginaDestino);

				} else {

					pageResponse.adicionar(mensagemUtil.getMensagemPropriedades("INVALIDACCESS", email.getValor()));
					pageResponse.setPageUrl(pagina.getClass());

				}

				return pageResponse;
			}
		}, true).build();

		botaoAcesso.setImediato(false);

		adicionar(0, email).
		adicionar(1, senha).
		adicionar(2, botaoAcesso);
	}
	
	public IEntradaEmail getEmail() {
		return email;
	}

	public IEntradaSenha getSenha() {
		return senha;
	}
	
}
