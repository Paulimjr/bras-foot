package br.com.repository;

import br.com.entity.GolsPartida;
import br.com.entity.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The repository for the {@link Partida}
 * 
 * @author paulo
 *
 */
@Repository
public interface GolsRepository extends JpaRepository<GolsPartida, Integer> {


    List<GolsPartida> findByPartidaId(final Integer timeId);

}
