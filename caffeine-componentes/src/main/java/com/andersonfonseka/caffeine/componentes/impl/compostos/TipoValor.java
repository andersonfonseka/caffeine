package com.andersonfonseka.caffeine.componentes.impl.compostos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.andersonfonseka.caffeine.componentes.IBotao;
import com.andersonfonseka.caffeine.componentes.IComponenteFabrica;
import com.andersonfonseka.caffeine.componentes.ITipoValor;
import com.andersonfonseka.caffeine.componentes.IEntradaOculta;
import com.andersonfonseka.caffeine.componentes.IEntradaTexto;
import com.andersonfonseka.caffeine.componentes.IPagina;
import com.andersonfonseka.caffeine.componentes.IResposta;
import com.andersonfonseka.caffeine.componentes.ISelecao;
import com.andersonfonseka.caffeine.componentes.ITabela;
import com.andersonfonseka.caffeine.componentes.acao.AcaoAbs;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Conteiner;
import com.andersonfonseka.caffeine.componentes.impl.compostos.dominio.TipoValorBean;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class TipoValor extends Conteiner implements ITipoValor {

	private static final long serialVersionUID = 1L;
	
	@Inject
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	IComponenteFabrica componenteFabrica;
	
	private ISelecao selTipo;
	
	private IEntradaTexto txValor;
	
	private IBotao btnAdicionar;
	
	private ITabela tblTipoValores;
	
	private IPagina pagina;
	
	private IEntradaOculta txDados;
	
	public TipoValor(IComponenteFabrica componenteFabrica, IPagina pPagina, ISelecao selecaoTipo) {

		super(5);
		this.componenteFabrica = componenteFabrica;
		this.pagina = pPagina;
		
		this.txDados = componenteFabrica.criarEntradaOculta("");
		
		this.selTipo = selecaoTipo;
		
		this.txValor = componenteFabrica.criarEntradaTexto("Valor", true);

		this.tblTipoValores = componenteFabrica.criarTabela("tblTipoValor");
		this.tblTipoValores.adicionaColuna(componenteFabrica.criarTabelaColuna("Tipo", "getTipo"));
		this.tblTipoValores.adicionaColuna(componenteFabrica.criarTabelaColuna("Valor", "getValor"));
		
		this.btnAdicionar = componenteFabrica.criarBotao("Adicionar", new AcaoAbs(tblTipoValores) {
			@Override
			public IResposta execute() {

				TipoValorBean documento = new TipoValorBean();
				documento.setTipo(selTipo.getSelecionado().getRotulo());
				documento.setValor(txValor.getValor());
				
				IResposta resposta = componenteFabrica.criarResposta();
				resposta.setAtributo(txDados.getValor() + documento.toString());
				resposta.setPageUrl(pagina.getClass().getName());
				return resposta;

			}
		}, true);
		
		this.btnAdicionar.setImediato(true);
		
		adicionar(0, txDados);
		adicionar(1, selTipo);
		adicionar(2, txValor);
		adicionar(3, btnAdicionar);
		adicionar(4, tblTipoValores);

	}
	
	private List<TipoValorBean> getListaValores(){
		
		String valores = txDados.getValor();
		List<TipoValorBean> documentos = new ArrayList<TipoValorBean>();
		String[] resultado = valores.split(";");
		
		for (int i = 0; i < resultado.length; i++) {
			
			String[] doc = resultado[i].split("#");
			
			TipoValorBean documento = new TipoValorBean();
			documento.setTipo(doc[0]);
			documento.setValor(doc[1]);

			documentos.add(documento);
		}
		
		return documentos;
	}

	@Override
	public void aoCarregar(Map<String, Object> parametros) {
		super.aoCarregar(parametros);
		
		if (parametros.containsKey("attrib_")) {
			txDados.setValor(String.valueOf(parametros.get("attrib_")));
			System.out.println(txDados.getValor());
			tblTipoValores.setDados(getListaValores());
		}
	}

	public IEntradaOculta getDados() {
		return txDados;
	}
	
}
