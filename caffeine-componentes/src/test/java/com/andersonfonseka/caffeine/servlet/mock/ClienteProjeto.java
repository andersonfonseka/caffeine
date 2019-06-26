package com.andersonfonseka.caffeine.servlet.mock;

import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;

import com.andersonfonseka.caffeine.IComponente;
import com.andersonfonseka.caffeine.IComponenteFabrica;
import com.andersonfonseka.caffeine.IPagina;
import com.andersonfonseka.caffeine.IProjeto;
import com.andersonfonseka.caffeine.componentes.impl.basicos.Projeto;
import com.andersonfonseka.caffeine.componentes.impl.mock.AcessoPagina;

@SessionScoped
public class ClienteProjeto implements IProjeto {
		
		private static final long serialVersionUID = 1L;
		
		private Projeto projeto;

		public ClienteProjeto() {}

		public void aoCarregar(Map<String, Object> parametros) {}

		@Override
		public void setComponenteFabrica(IComponenteFabrica componenteFabrica) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<IComponente> getComponentes() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setParent(String parentName) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getParent() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public IComponente adicionar(IComponente component) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String gerarSaida() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getTemplate() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setTitulo(String titulo) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public IPagina obterPaginaPeloId(String id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public IPagina getPaginaInicial() {
			
			try {
				return AcessoPagina.class.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
			return null;
		}

		@Override
		public void setPaginaInicial(Class<? extends IPagina> pagina) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getTitulo() {
			return "Caffeine Hello World!";
		}

}
