package com.andersonfonseka.caffeine.componentes.impl.compostos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.andersonfonseka.caffeine.IBotao;
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IEntradaOculta;
import com.andersonfonseka.caffeine.IEntradaTexto;
import com.andersonfonseka.caffeine.IPagina;
import com.andersonfonseka.caffeine.IResposta;
import com.andersonfonseka.caffeine.ISelecao;
import com.andersonfonseka.caffeine.ITabela;
import com.andersonfonseka.caffeine.ITipoValor;
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
		
		this.txDados = componenteFabrica.criarEntradaOculta(this.getId()+"_EntradaOculta", "");
		
		this.selTipo = selecaoTipo;
		
		this.txValor = componenteFabrica.criarEntradaTexto("Valor", false);

		this.tblTipoValores = componenteFabrica.criarTabela("tbl" + getId())
				.adicionaColuna(componenteFabrica.criarTabelaColuna("#", "getId", true))
				.adicionaColuna(componenteFabrica.criarTabelaColuna("Tipo", "getTipo"))
				.adicionaColuna(componenteFabrica.criarTabelaColuna("Valor", "getValor"));
		
		this.btnAdicionar = componenteFabrica.criarBotao("Adicionar", new AcaoAbs(tblTipoValores) {
			@Override
			public IResposta execute() {

				TipoValorBean documento = new TipoValorBean();
				documento.setTipo(selTipo.getSelecionado().getRotulo());
				documento.setValor(txValor.getValor());
				
				txDados.setValor(txDados.getValor() + documento.toString());
				
				IResposta resposta = componenteFabrica.criarResposta();
				resposta.setAtributo(txDados.getId(), txDados.getValor());
				resposta.setPageUrl(pagina.getClass());
				return resposta;

			}
		}, true);
		
		this.btnAdicionar.setImediato(true);
		this.btnAdicionar.setParent(this.getId());
		
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
			documento.setId(doc[0]);
			documento.setTipo(doc[1]);
			documento.setValor(doc[2]);

			documentos.add(documento);
		}
		
		return documentos;
	}

	@Override
	public void aoCarregar(Map<String, Object> parametros) {
		super.aoCarregar(parametros);
		
		if (parametros.containsKey(txDados.getId())) {
			txDados.setValor(String.valueOf(parametros.get(txDados.getId())));
			
			if (txDados.getValor().trim().length() > 0) {
				tblTipoValores.setDados(getListaValores());	
			}
		}
	}
	
}
