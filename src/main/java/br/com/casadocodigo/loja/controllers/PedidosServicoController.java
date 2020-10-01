package br.com.casadocodigo.loja.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.casadocodigo.loja.models.Pedido;

@Controller
@RequestMapping("/pedidos")
public class PedidosServicoController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView solicitarPedidos(RedirectAttributes model) throws JsonParseException, JsonMappingException, IOException {
		String uri = "https://book-payment.herokuapp.com/orders";
	
		String response = restTemplate.getForObject(uri, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		Pedido[] pedido = mapper.readValue(response, Pedido[].class);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pedidos",pedido);
		
		return modelAndView;	
	}
}
