package br.com.resources;

import br.com.response.TeamResponse;
import br.com.entity.Team;
import br.com.services.TeamService;
import br.com.dto.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/time")
public class TeamResource {

    @Autowired
    private TeamService teamService;

    /**
     * API para inserir um team
     *
     * @param objDto
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody TeamDTO objDto) {
        Team obj = this.teamService.fromDTO(objDto);
        this.teamService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    /**
     * API para inserir um team
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/novojogador/{id}", method=RequestMethod.PUT)
    public ResponseEntity<TeamResponse> insertJogador(@PathVariable final Integer id, @RequestParam(value = "jogadorId") Integer jogadorId) {
        TeamResponse obj = this.teamService.inserirJogador(id, jogadorId);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * API para trazer todos os pois
     *
     * @return
     */
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<TeamDTO>> findAll() {
        List<Team> list = this.teamService.findAll();
        List<TeamDTO> listDto = list.stream().map(obj -> new TeamDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    /**
     * API para consultar um poi pelo identificador
     *
     * @author paulo
     * @param id o identificador do poi
     * @return o poi
     */
    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable final Integer id) {
        Team team = this.teamService.findById(id);
        return  ResponseEntity.ok().body(team);
    }

    /**
     * API para consultar um poi pelo identificador
     *
     * @author paulo
     * @param id o identificador do poi
     * @return o poi
     */
    @RequestMapping(value = "/jogadores/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> jogadoresTime(@PathVariable final Integer id) {
        TeamResponse team = this.teamService.jogadoresTime(id);
        return  ResponseEntity.ok().body(team);
    }

}
