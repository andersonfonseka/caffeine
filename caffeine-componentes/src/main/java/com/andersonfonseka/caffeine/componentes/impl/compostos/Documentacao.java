package com.andersonfonseka.caffeine.componentes.impl.compostos;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.IDocumentacao;
import com.andersonfonseka.caffeine.componentes.IEntradaMemoria;
import com.andersonfonseka.caffeine.componentes.IEntradaTexto;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.ISelecao;
import com.andersonfonseka.caffeine.componentes.ITabela;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Conteiner;
import com.andersonfonseka.caffeine.util.MensagemUtil;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class Documentacao extends Conteiner implements IEntradaMemoria, IDocumentacao {

	private static final long serialVersionUID = 1L;
	
	private MensagemUtil mensagemUtil = new MensagemUtil();
	
	@Inject
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	IComponenteFabrica componenteFabrica;
	
	private ISelecao selTipo;
	
	private IEntradaTexto txtNumero;
	
	private IBotao btnAdicionar;
	
	private ITabela tblDocumentos;
	
	private Map<String, String> documentos;
	
	public Documentacao(IComponenteFabrica componenteFabrica, Map<String, String> documentos) {

		super(4);
		this.componenteFabrica = componenteFabrica;
		
		this.selTipo = componenteFabrica.criarSelecao("Tipo de documento", true);
		this.selTipo.adicionar(componenteFabrica.criarOpcaoSelecao("1", "RG"));
		this.selTipo.adicionar(componenteFabrica.criarOpcaoSelecao("2", "Carteira de habilitacao"));
		this.selTipo.adicionar(componenteFabrica.criarOpcaoSelecao("3", "CPF"));
		this.selTipo.adicionar(componenteFabrica.criarOpcaoSelecao("4", "CTPS"));
		this.selTipo.adicionar(componenteFabrica.criarOpcaoSelecao("5", "Passaporte"));
		
		this.txtNumero = componenteFabrica.criarEntradaTexto("Numero do documento", true);
		
		this.btnAdicionar = componenteFabrica.criarBotao("Adicionar", new AcaoAbs(this) {
			@Override
			public IResposta execute() {
				// TODO Auto-generated method stub
				return null;
			}
		}, false);
	
		this.tblDocumentos = componenteFabrica.criarTabela("tblDocumentacao");
		this.tblDocumentos.adicionaColuna(componenteFabrica.criarTabelaColuna("Tipo do documento", "getTipo"));
		this.tblDocumentos.adicionaColuna(componenteFabrica.criarTabelaColuna("Numero do documento", "getNumero"));
		
		adicionar(0, selTipo);
		adicionar(1, txtNumero);
		adicionar(2, btnAdicionar);
		adicionar(3, tblDocumentos);
		
	}
	
	
	@Override
	public void setValor(String pValor) {}

	@Override
	public String getValor() {	
		return null;
	}

	@Override
	public List<String> validar() {
		return null;
	}

	@Override
	public boolean isObrigatorio() {
		return false;
	}

	@Override
	public Map<String, String> getLista() {
		return this.documentos;
	}

}
