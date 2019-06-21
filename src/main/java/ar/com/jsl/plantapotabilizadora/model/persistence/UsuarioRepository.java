package ar.com.jsl.plantapotabilizadora.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.jsl.plantapotabilizadora.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public List<Usuario> findByFirstNameLikeAndEnabledTrueOrderByUsername(String parteDelNombre);

	public List<Usuario> findByUsernameOrEmail(String username, String email);

	public List<Usuario> findByUsername(String username);
}