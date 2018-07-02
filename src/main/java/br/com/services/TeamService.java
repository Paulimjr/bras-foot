package br.com.services;

import br.com.response.TeamResponse;
import br.com.entity.Player;
import br.com.entity.Team;
import br.com.dto.TeamDTO;
import br.com.exceptions.ObjectNotFoundException;
import br.com.repository.PlayerRepository;
import br.com.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Controlar serviços de {@link }
 * 
 * @author paulo
 *
 */
@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private PlayerRepository playerRepository;
	
	/**
	 * Trazer todos os poi cadastrados
	 * 
	 * @return 
	 */
	public List<Team> findAll() {
		return this.teamRepository.findAll();
	}
	
	/**
	 * Lista poi pelo nome
	 * 
	 * @return 
	 */
	public List<Team> findByName(final String name) {
		return this.teamRepository.findByName(name);
	}

	/**
	 * Método para buscar um poi pelo ID
	 * 
	 * @author paulo
	 * @throws ObjectNotFoundException
	 * @param id o identificador do poi
	 * @return o poi caso encontre.
	 */
	public Team findById(final Integer id) {
		Team team = this.teamRepository.findOne(id);
		
		if (team == null) {
			throw new ObjectNotFoundException(String.format("Team com o ID %s não foi encontrado.", id));
		}
		
		return team;
	}
	
	/**
	 * Converter PoiDTO para entidade Poi
	 * 
	 * @param objDto
	 * @return
	 */
	public Team fromDTO(TeamDTO objDto) {
		return new Team(objDto.getId(), objDto.getName(), objDto.getImage(), objDto.getTotalPontos());
	}

	/**
	 * Remover um POI cadastrado
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		
		this.findById(id);		
		this.teamRepository.delete(id);
	}

	/**
	 * Método para inserir um novo POI 
	 * 
	 * @param obj
	 * @return
	 */
	public void insert(Team obj) {
		obj.setId(null);
		this.teamRepository.save(obj);
	}

	public TeamResponse jogadoresTime(Integer id) {

		Team team = this.findById(id);
		TeamResponse response = new TeamResponse();

		response.setTimeId(team.getId());
		response.setImagemTime(team.getImage());
		response.setTime(team.getName());
		response.setPontos(team.getTotalPontos());

		response.setJogadores(this.playerRepository.findByTimeId(id));

		return response;
	}

	public TeamResponse inserirJogador(Integer id, Integer jogadorId) {

		findById(id);
		TeamResponse response = new TeamResponse();
		Player player = playerRepository.findOne(jogadorId);

		if (player.getTimeId() != 0) {
			throw new ObjectNotFoundException(String.format("Jogador já está em um Time.", id));
		} else {
			player.setTimeId(id);
			playerRepository.save(player);

			Team team = findById(id);

			response.setTimeId(team.getId());
			response.setImagemTime(team.getImage());
			response.setTime(team.getName());
			response.setPontos(team.getTotalPontos());

			response.setJogadores(this.playerRepository.findByTimeId(id));
		}

		return response;
	}
}
