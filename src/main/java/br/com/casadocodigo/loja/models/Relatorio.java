package br.com.casadocodigo.loja.models;

import java.util.List;

public class Relatorio {

	private Long dataGeracao;
	private Long quantidade;
	private List<Produto> produtos;
	
	public Relatorio() {}

	public Relatorio(Long dataGeracao, Long quantidade, List<Produto> produtos) {
		this.dataGeracao = dataGeracao;
		this.quantidade = quantidade;
		this.produtos = produtos;
	}

	public Long getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(Long dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
