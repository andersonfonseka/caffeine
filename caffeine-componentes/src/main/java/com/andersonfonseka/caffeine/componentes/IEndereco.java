package com.andersonfonseka.caffeine.componentes;

public interface IEndereco extends IConteiner {

	public IEntradaTexto getLogradouro();

	public IEntradaNumero getNumero();

	public IEntradaTexto getComplemento();

	public IEntradaTexto getBairro();

	public ISelecao getEstado();

	public ISelecao getCidade();

}
