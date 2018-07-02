package br.com.resources;

import br.com.dto.PlayerDTO;
import br.com.dto.TeamDTO;
import br.com.entity.Player;
import br.com.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/jogador")
public class PlayerResource {

    @Autowired
    private PlayerService playerService;

    /**
     * API para inserir um team
     *
     * @param objDto
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody PlayerDTO objDto) {
        Player obj = this.playerService.fromDTO(objDto);
        this.playerService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    /**
     * API para trazer todos os pois
     *
     * @return
     */
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<PlayerDTO>> findAll() {
        List<Player> list = this.playerService.findAll();
        List<PlayerDTO> listDto = list.stream().map(obj -> new PlayerDTO(obj)).collect(Collectors.toList());

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
        Player player = this.playerService.findById(id);
        return  ResponseEntity.ok().body(player);
    }

}
