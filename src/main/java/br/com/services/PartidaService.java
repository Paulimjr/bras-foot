package br.com.services;

import br.com.dto.GolsDTO;
import br.com.dto.PartidaDTO;
import br.com.dto.PlayerDTO;
import br.com.entity.GolsPartida;
import br.com.entity.Partida;
import br.com.entity.Player;
import br.com.entity.Team;
import br.com.exceptions.ObjectNotFoundException;
import br.com.repository.GolsRepository;
import br.com.repository.PartidaRepository;
import br.com.repository.PlayerRepository;
import br.com.repository.TeamRepository;
import br.com.response.PartidaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    private List<GolsDTO> convert(List<GolsPartida> golsPartidas) {
	    return null;
    }

}
