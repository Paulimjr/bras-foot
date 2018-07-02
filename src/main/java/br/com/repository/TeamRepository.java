package br.com.repository;

import br.com.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The repository for the {@link Poi}
 * 
 * @author paulo
 *
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

	/**
	 * Retornar os team pelo nome
	 * 
	 * @param name
	 * @return
	 */
	List<Team> findByName(final String name);
}
