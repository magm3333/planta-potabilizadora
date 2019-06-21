package ar.com.jsl.plantapotabilizadora.model.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.jsl.plantapotabilizadora.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

	public List<Rol> findByRol(String rol);
}
