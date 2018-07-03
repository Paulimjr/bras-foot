package br.com.services;

import br.com.dto.PlayerDTO;
import br.com.entity.Player;
import br.com.entity.Team;
import br.com.exceptions.ObjectNotFoundException;
import br.com.repository.PlayerRepository;
import br.com.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service controller to {@link PlayerService}
 * 
 * @author paulo
 *
 */
@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
    private TeamRepository teamRepository;
	
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
		return new Player(objDto.getId(), objDto.getName(), objDto.getTotalPontos(), objDto.getTimeId(), objDto.getPhoto(),
                objDto.getTitular(), objDto.getPosicao());
	}

    /**
     * Converter PoiDTO para entidade Poi
     *
     * @param objDto
     * @return
     */
    public PlayerDTO toDto(Player objDto) {
        return new PlayerDTO(objDto);
    }

	public String substituicao(Player tirar, Player colocar) {
        String success;

        if (tirar.getTitular().equalsIgnoreCase(Player.TypeTitular.TITULAR_NO)) {
            throw new ObjectNotFoundException(String.format("O jogador %s não está como titular. " +
                    "Operação não será efetuada!", tirar.getName()));
        } else {
            if (colocar.getTitular().equalsIgnoreCase(Player.TypeTitular.TITULAR_YES)) {
                throw new ObjectNotFoundException(String.format("O jogador %s já está como titular. " +
                        "Operação não será efetuada!", colocar.getName()));
            } else {
                tirar.setTitular(Player.TypeTitular.TITULAR_NO);
                colocar.setTitular(Player.TypeTitular.TITULAR_YES);
                this.playerRepository.save(tirar);
                this.playerRepository.save(colocar);
                success = "Substituição efetuada com sucesso! - Novo jogador em campo: "+colocar.getName();
            }
        }

        return success;
    }
    /**
     * Update player for titular
     *
     * return player updated
     */
    public Player tirarJogador(final Integer id) {
        Player player = this.findById(id);

        if (player.getTitular() != null && player.getTitular().equalsIgnoreCase(Player.TypeTitular.TITULAR_NO)) {
            throw new ObjectNotFoundException(String.format("O jogador %s não está como titular. " +
                    "Operação não será efetuada!", player.getName()));
        } else {
            player.setTitular(Player.TypeTitular.TITULAR_NO);
            player = this.playerRepository.save(player);
        }

        return player;
    }

    /**
     * Update player for titular
     *
     * return player updated
     */
    public Player colocarJogador(final Integer id) {
        Player player = this.findById(id);

        if (player.getTitular() != null && player.getTitular().equalsIgnoreCase(Player.TypeTitular.TITULAR_YES)) {
            throw new ObjectNotFoundException(String.format("O jogador %sjá está como titular. " +
                    "Operação não será efetuada!", player.getName()));
        } else {
            player.setTitular(Player.TypeTitular.TITULAR_YES);
            player = this.playerRepository.save(player);
        }

        return player;
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

        Team team = teamRepository.findOne(obj.getTimeId());

        obj.setTimeId(team.getId());
        obj.setTeamName(team.getName());
		obj.setPhoto(obj.getPhoto());
		obj.setTitular(obj.getTitular());

		this.playerRepository.save(obj);
	}
}
