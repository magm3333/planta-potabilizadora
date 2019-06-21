package ar.com.jsl.plantapotabilizadora.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.jsl.plantapotabilizadora.model.AuthToken;

@Repository
public interface AuthTokenRespository extends JpaRepository<AuthToken, String> {
}