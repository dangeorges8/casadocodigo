package br.com.casadocodigo.loja.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;

@RestController
@RequestMapping("/relatorio-produtos")
public class RelatorioProdutosController {

	@Autowired
	private ProdutoDAO produtoDao;

	@DateTimeFormat
	private Calendar dataGeracao;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Produto> gerarRelatorio
		(@RequestParam(value = "data", defaultValue = "1970-1-1") String data) {

		String[] dataSegmentada = data.split("-");
		Integer ano = Integer.parseInt(dataSegmentada[0]);
		Integer mes = Integer.parseInt(dataSegmentada[1]);
		Integer dia = Integer.parseInt(dataSegmentada[2]);
			
		dataGeracao = new GregorianCalendar(ano, dia, mes);
		
		List<Produto> produtos = produtoDao.relatorioDeProdutos(dataGeracao);

		return produtos;
	}

}
