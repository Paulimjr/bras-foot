package br.com.services;

import br.com.dto.PlayerDTO;
import br.com.entity.Player;
import br.com.exceptions.ObjectNotFoundException;
import br.com.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Controlar serviços de {@link PlayerService}
 * 
 * @author paulo
 *
 */
@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	/**
	 * Trazer todos os poi cadastrados
	 * 
	 * @return 
	 */
	public List<Player> findAll() {
		return this.playerRepository.findAll();
	}
	
	/**
	 * Lista poi pelo nome
	 * 
	 * @return 
	 */
	public List<Player> findByName(final String name) {
		return this.playerRepository.findByName(name);
	}

	/**
	 * Método para buscar um poi pelo ID
	 * 
	 * @author paulo
	 * @param id o identificador do poi
	 * @return o poi caso encontre.
	 */
	public Player findById(final Integer id) {
		Player team = this.playerRepository.findOne(id);
		
		if (team == null) {
			throw new ObjectNotFoundException(String.format("Player com o ID %s não foi encontrado.", id));
		}
		
		return team;
	}
	
	/**
	 * Converter PoiDTO para entidade Poi
	 * 
	 * @param objDto
	 * @return
	 */
	public Player fromDTO(PlayerDTO objDto) {
		return new Player(objDto.getId(), objDto.getName(), objDto.getTotalPontos(), objDto.getTimeId());
	}

	/**
	 * Remover um POI cadastrado
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		
		this.findById(id);		
		this.playerRepository.delete(id);
	}

	/**
	 * Método para inserir um novo POI 
	 * 
	 * @param obj
	 * @return
	 */
	public void insert(Player obj) {
		obj.setId(null);
		obj.setTimeId(0);
		this.playerRepository.save(obj);
	}
}
