package br.com.services;

import br.com.dto.GolsDTO;
import br.com.dto.PartidaDTO;
import br.com.dto.SubstituicaoDTO;
import br.com.entity.GolsPartida;
import br.com.entity.Partida;
import br.com.entity.Player;
import br.com.entity.Team;
import br.com.exceptions.ObjectNotFoundException;
import br.com.repository.GolsRepository;
import br.com.repository.PartidaRepository;
import br.com.repository.PlayerRepository;
import br.com.repository.TeamRepository;
import br.com.response.DetalhePartida;
import br.com.response.PartidaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlar serviços de {@link Partida}
 * 
 * @author paulo
 *
 */
@Service
public class PartidaService {

	@Autowired
	private PartidaRepository partidaRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private PlayerService playerService;

    @Autowired
    private GolsRepository golsRepository;
	
	/**
	 * Trazer todos os Partida cadastrados
	 * 
	 * @return 
	 */
	public List<Partida> findAll() {
		return this.partidaRepository.findAll();
	}

	/**
	 * Método para buscar um Partida pelo ID
	 * 
	 * @author paulo
	 * @param id o identificador do poi
	 * @return o Partida caso encontre.
	 */
	public Partida findById(final Integer id) {
		Partida partida = this.partidaRepository.findOne(id);
		
		if (partida == null) {
			throw new ObjectNotFoundException(String.format("Partida com o ID %s não foi encontrado.", id));
		}
		
		return partida;
	}
	
	/**
	 * Converter PoiDTO para entidade Poi
	 * 
	 * @param objDto
	 * @return
	 */
	public Partida fromDTO(PartidaDTO objDto) {
		return new Partida(objDto.getId(), objDto.getTimeoOne(), objDto.getTimeoTwo(), objDto.getStatusPatida(),
				objDto.getTimeVencedor());
	}

	/**
	 * Remover um POI cadastrado
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		this.findById(id);		
		this.partidaRepository.delete(id);
	}

	/**
	 * Método para inserir um novo POI 
	 * 
	 * @param obj
	 * @return
	 */
	public void insert(Partida obj) {
		obj.setId(null);
		obj.setStatusPatida("EM ANDAMENTO");
		obj.setTimeVencedor(0);
		this.partidaRepository.save(obj);
	}

    public PartidaResponse lancarGol(Integer id, Integer timeEfetuouGol, Integer jogadorEfetuouGol, Integer numGol) {

	    Partida partida = this.partidaRepository.findOne(id);
        GolsPartida golsPartida = new GolsPartida(null, partida.getId(), timeEfetuouGol, jogadorEfetuouGol, numGol);

        golsRepository.save(golsPartida);

        Team time1 = this.teamRepository.findOne(partida.getTimeoOne());
        Team time2 = this.teamRepository.findOne(partida.getTimeoTwo());

        List<GolsPartida> gols = golsRepository.findByPartidaId(partida.getId());

        PartidaResponse response =
                new PartidaResponse(partida.getId(), time1, time2, partida.getStatusPatida(),partida.getTimeVencedor(), gols);

        return response;
    }

	/**
	 * Mostrar partida detalhada
	 *
	 * @param id
	 * @return
	 */
	public DetalhePartida partidaDetalhada(Integer id) {

		Partida partida = findById(id);

		Team time1 = this.teamRepository.findOne(partida.getTimeoOne());
		Team time2 = this.teamRepository.findOne(partida.getTimeoTwo());

		List<GolsPartida> gols = golsRepository.findByPartidaId(partida.getId());
		List<GolsDTO> golsEfetuados = convert(gols);


		DetalhePartida detalhePartida = new DetalhePartida(partida.getId(),
				time1, time2, partida.getStatusPatida(), partida.getTimeVencedor(), golsEfetuados);

		detalhePartida.setTotal_gols_time_one(sumTotalGols(gols, time1.getId()));
		detalhePartida.setTotal_gols_time_two(sumTotalGols(gols, time2.getId()));

		return detalhePartida;
	}


	private int sumTotalGols(List<GolsPartida> gols, Integer time) {
		int total = 0;

		for (GolsPartida dto : gols) {
			if (dto.getTimeEfetuouGol().equals(time)) {
				total = total + dto.getNumGol();
			}
		}

		return total;
	}


    private List<GolsDTO> convert(List<GolsPartida> golsPartidas) {
		List<GolsDTO> golsEfetuados = new ArrayList<>();

		if (golsPartidas != null) {
			for (GolsPartida gol : golsPartidas) {
				GolsDTO dto = golResponse(gol);
				golsEfetuados.add(dto);
			}
		}

	    return golsEfetuados;
    }

    private GolsDTO golResponse(GolsPartida gol) {
		GolsDTO dto = new GolsDTO();

		Player player = this.playerRepository.findOne(gol.getJogador_efetuou_gol());
		Team team = this.teamRepository.findOne(gol.getTimeEfetuouGol());

		dto.setJogadorEfetuouGol(player.getName());
		dto.setTimeEfetuouGol(team.getName());
		dto.setNumGol(gol.getNumGol());

		return dto;
	}

	/**
	 * Substituir jogador em partida
	 *
	 * @param obj TimeId, Jog sair, Jog entrar...
	 * @return
	 */
	public String substituicao(SubstituicaoDTO obj) {
		String response;

		if (obj ==  null) {
			throw new ObjectNotFoundException("Parametros par substituição não informados!");
		} else {
			Team time = this.teamRepository.findOne(obj.getTimeId());
			if (time == null) {
				throw new ObjectNotFoundException("O time informado não foi encontrado!");
			} else {

				Player playerSaiu = this.playerRepository.findOne(obj.getJogadorSaiu());
				Player playerEntrou = this.playerRepository.findOne(obj.getJogadorEntrou());
				boolean validatePlayers = validatePlayesAndTeam(playerSaiu, playerEntrou, time.getId());

				if (validatePlayers) {
					response = playerService.substituicao(playerSaiu, playerEntrou);
				} else {
					throw new ObjectNotFoundException("Algum dos jogadores informados não joga neste time!");
				}
			}
		}

		return response;
	}

	private boolean validatePlayesAndTeam(Player playerSaiu, Player playerEntrou, Integer teamId) {

		if (playerSaiu == null) {
			throw new ObjectNotFoundException("O jogador que você está tirando não foi encontrado!");
		}

		if (playerEntrou == null) {
			throw new ObjectNotFoundException("O jogador que você está colocando não foi encontrado!");
		}

		return existsInTime(teamId, playerSaiu.getTimeId(), playerEntrou.getTimeId());
	}

	private boolean existsInTime(Integer timeId, Integer jogadorSaiu, Integer jogadorEntrou) {

		if (!jogadorSaiu.equals(timeId)) {
			return false;
		}

		if (!jogadorEntrou.equals(timeId)) {
			return false;
		}

		return true;
	}
}
