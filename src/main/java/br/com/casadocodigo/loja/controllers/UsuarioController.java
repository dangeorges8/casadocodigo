package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDao;

	@Autowired
	private RoleDAO roleDao;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation());
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("usuarios/form");
		return modelAndView;
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ModelAndView gravar(@Valid Usuario usuario, BindingResult result, RedirectAttributes redirectAttributes) {
		boolean emailRepetido = usuarioDao.listarEmails().contains(usuario.getEmail());

		if (emailRepetido) {
			result.rejectValue("email", "field.required.usuario.emailRepetido");
		} else if (result.hasErrors()) {
			return form(usuario);
		}
		String senhaCriptografada = new BCryptPasswordEncoder().encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		
		usuarioDao.gravar(usuario);

		redirectAttributes.addFlashAttribute("message", "Usuário cadastrado com sucesso");
		return new ModelAndView("redirect:/usuarios");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Usuario> usuariosComRoles = usuarioDao.listarUsuariosComRoles();
		List<Usuario> usuariosSemRoles = usuarioDao.listarUsuariosSemRoles();

		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		modelAndView.addObject("usuariosComRoles", usuariosComRoles);
		modelAndView.addObject("usuariosSemRoles", usuariosSemRoles);

		return modelAndView;
	}

	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ModelAndView editarRoles(String email) {
		ModelAndView modelAndView = new ModelAndView("/usuarios/roles");
		Usuario usuario = usuarioDao.find(email);
		List<Role> listaRoles = roleDao.listar();
		modelAndView.addObject("listaRoles", listaRoles);
		modelAndView.addObject("usuario", usuario);

		return modelAndView;
	}

	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public ModelAndView gravarRoles(Usuario usuarioRequest, String email, String nome,
			RedirectAttributes redirectAttributes) {
		Usuario usuario = usuarioDao.find(email);
		usuarioRequest.setNome(nome);
		
		boolean RolesAlteradas = 
				!usuario.getRoles().toString().equals(usuarioRequest.getRoles().toString());

		usuario.setRoles(usuarioRequest.getRoles());
		usuarioDao.gravar(usuario);

		if (RolesAlteradas) {
			redirectAttributes.addFlashAttribute("message", "Permissões alteradas com sucesso");
		}
		return new ModelAndView("redirect:/usuarios");
	}
}
