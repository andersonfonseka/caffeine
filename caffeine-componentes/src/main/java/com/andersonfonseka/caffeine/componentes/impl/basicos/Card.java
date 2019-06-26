package com.andersonfonseka.caffeine.componentes.impl.basicos;

import com.andersonfonseka.caffeine.IBotao;
import com.andersonfonseka.caffeine.ICard;
import com.andersonfonseka.caffeine.componentes.impl.Componente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
public @Data class Card extends Componente implements ICard {

	private static final long serialVersionUID = 4099784173983962979L;
	
	private String titulo;
	
	private String texto;
	
	private String imagem;
	
	private Card() {}
	
	@Override
	public String getTemplate() {
		return "card";
	}

	@Override
	public void setBotao(IBotao botao) {
		adicionar(botao);
	}
	
	public static class Builder {
		
		String imagem;
		String titulo; 
		String texto;
		
		public Builder(String imagem, String titulo, String texto) {
			super();
			this.imagem = imagem;
			this.titulo = titulo;
			this.texto = texto;
		}
		
		public ICard build() {
			
			Card card = new Card();

			card.setTitulo(titulo);
			card.setTexto(texto);
			card.setImagem(imagem);
			
			return card;
		}
		
	}

	
}
