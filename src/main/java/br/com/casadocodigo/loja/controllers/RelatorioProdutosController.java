package br.com.casadocodigo.loja.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.loja.dao.ProdutoDAO;

@RestController
@RequestMapping("/relatorio-produtos")
public class RelatorioProdutosController {
	
	@Autowired
	private ProdutoDAO produtoDao;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<String> relatorioProdutos(){
		ArrayList<String> list = new ArrayList<>();
		list.add("Primeiro");
		list.add("segundo");
		
		return list;
	}

}
