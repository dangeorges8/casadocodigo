package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Usuario;

@Repository
@Transactional
public class UsuarioDAO implements UserDetailsService{

	@PersistenceContext
	private EntityManager manager;

	public Usuario loadUserByUsername(String email) {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
				.setParameter("email", email)
				.getResultList();
		
		if(usuarios.isEmpty()) {
			throw new UsernameNotFoundException("Usuario " + email + " não foi encontrado");
		}
		
		return usuarios.get(0);
	}
	
	public Usuario find(String email) {

		Usuario usuario = manager
				.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
				.setParameter("email", email)
				.getSingleResult();
		
		return usuario;
	}

	public void gravar(Usuario usuario) {
		manager.persist(usuario);
	}
	
	public List<Usuario> listarUsuariosComRoles(){
		return manager.createQuery("select distinct(u) from Usuario u join fetch u.roles", Usuario.class).getResultList();
	}
	
	public List<Usuario> listarUsuariosSemRoles(){
		return manager.createQuery("select u from Usuario u where not exists(select distinct(us) from Usuario us join us.roles where u.email = us.email)", Usuario.class)
				.getResultList();
	}
	
	public List<String> listarEmails(){
		List<String> listaDeEmails = manager
				.createQuery("select u.email from Usuario u", String.class)
				.getResultList();
		return listaDeEmails;
	}
	
	public void gravarRoles(Usuario usuario) {
		
	}
}