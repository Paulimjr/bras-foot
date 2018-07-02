package br.com.repository;

import br.com.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The repository for the {@link Time}
 * 
 * @author paulo
 *
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

	/**
	 * Retornar os Player pelo nome
	 * 
	 * @param name
	 * @return
	 */
	List<Player> findByName(final String name);

	List<Player> findByTimeId(final Integer timeId);
}
