package br.com.casadocodigo.loja.controllers;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Relatorio;

@RestController
@RequestMapping("/relatorio-produtos")
public class RelatorioProdutosController {

	@Autowired
	private ProdutoDAO produtoDao;
	@DateTimeFormat
	private Long dataGeracao;
	@DateTimeFormat
	private Calendar dataRecebida;
	private Long quantidade;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String gerarRelatorio(@RequestParam(value = "data", defaultValue = "0-0-0") String data)
			throws JsonProcessingException {
		dataGeracao = System.currentTimeMillis();

		String[] dataSegmentada = data.split("-");
		Integer ano = Integer.parseInt(dataSegmentada[0]);
		Integer mes = Integer.parseInt(dataSegmentada[1]);
		Integer dia = Integer.parseInt(dataSegmentada[2]);
		
		dataRecebida = new GregorianCalendar(ano, mes, dia);
		List<Produto> produtos = produtoDao.relatorioDeProdutos(dataRecebida);
		
		quantidade = produtoDao.getQuantidadeProdutos(dataRecebida);

		Relatorio relatorio = new Relatorio(dataGeracao, quantidade, produtos);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(relatorio);

		return json;
	}

}
