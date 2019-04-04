package com.andersonfonseka.caffeine.componente;

import lombok.Data;

public @Data class Endereco extends Componente {
	
	private Conteiner conteiner;
	
	public Endereco() {
		
		conteiner = new Conteiner(4);
		
		EntradaTexto logradouro = new EntradaTexto();
		logradouro.setTitulo("Logradouro");
		
		EntradaNumero numero = new EntradaNumero();
		numero.setTitulo("Numero");

		EntradaTexto complemento = new EntradaTexto();
		complemento.setTitulo("Complemento");
		
		EntradaTexto bairro = new EntradaTexto();
		bairro.setTitulo("Bairro");
		
		EntradaTexto cidade = new EntradaTexto();
		cidade.setTitulo("Cidade");
		
		Selecao uf = new Selecao();
		uf.setTitulo("UF");
		uf.add(new OpcaoSelecao("1", "PE"));
		uf.add(new OpcaoSelecao("2", "SP"));
		uf.add(new OpcaoSelecao("3", "RJ"));
		
		conteiner.add(0, logradouro);
		conteiner.add(0, numero);
		conteiner.add(1, complemento);
		conteiner.add(1, bairro);
		conteiner.add(2, cidade);
		conteiner.add(2, uf);
	}

}
