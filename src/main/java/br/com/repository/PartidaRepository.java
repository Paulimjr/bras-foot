package br.com.repository;

import br.com.entity.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The repository for the {@link Partida}
 * 
 * @author paulo
 *
 */
@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer> {}
