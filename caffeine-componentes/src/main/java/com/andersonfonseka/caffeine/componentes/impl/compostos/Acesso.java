package com.andersonfonseka.caffeine.componentes.impl.compostos;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IAcesso;
import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IEntradaEmail;
import com.andersonfonseka.caffeine.componentes.IEntradaSenha;
import com.andersonfonseka.caffeine.componentes.IPagina;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Conteiner;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper=false)
public class Acesso extends Conteiner implements IAcesso {
	
	private static final long serialVersionUID = 1L;
	
	private MensagemUtil mensagemUtil = new MensagemUtil();
	
	@Inject
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	IComponenteFabrica componenteFabrica;
	
	private IEntradaEmail email;

	private IEntradaSenha senha;
	
	private IBotao botaoAcesso;
	
	private IPagina pagina;
	
	private Class<?> paginaDestino;
	
	private  Map<String, String> usuarios;
	
	public Acesso(IComponenteFabrica componenteFabrica, IPagina pagina, Map<String, String> usuarios, Class<?> paginaDestino) {
		
		super(3);
		this.componenteFabrica = componenteFabrica;
		this.pagina = pagina;
		this.paginaDestino = paginaDestino;
		this.usuarios = usuarios;
		post();
	
	}
	
	@PostConstruct
	public void post() {

		email = componenteFabrica.criarEntradaEmail("Email", true);

		senha = componenteFabrica.criarEntradaSenha("Senha", true);

		botaoAcesso = componenteFabrica.criarBotao("Conectar", new AcaoAbs(pagina) {
			public IResposta execute() {

				IResposta pageResponse = componenteFabrica.criarResposta();

				 if (usuarios.containsKey(email.getValor()) && 
						 usuarios.get(email.getValor()).equals(senha.getValor())) {
					pageResponse.setPageUrl(paginaDestino.getName());

				} else {

					pageResponse.adicionar(mensagemUtil.getMensagemPropriedades("INVALIDACCESS", email.getValor()));
					pageResponse.setPageUrl(pagina.getClass().getName());

				}

				return pageResponse;
			}
		}, true);

		botaoAcesso.setImediato(false);

		adicionar(0, email).
		adicionar(1, senha).
		adicionar(2, botaoAcesso);
	}
	
	@Override
	public void aoCarregar(Map<String, Object> parametros) {
		super.aoCarregar(parametros);
	}

	public IEntradaEmail getEmail() {
		return email;
	}

	public IEntradaSenha getSenha() {
		return senha;
	}
	
}
