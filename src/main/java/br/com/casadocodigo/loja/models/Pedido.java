package br.com.casadocodigo.loja.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Pedido {

	private Long id;
	private Double valor;
	private Calendar data;
	private Produto[] produtos;

	public Pedido() {
	}

	public Pedido(Long id, Double valor, Calendar data, Produto[] produtos) {
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.produtos = produtos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", valor=" + valor + ", data=" + data + ", produtos=" + produtos + "]";
	}

}
