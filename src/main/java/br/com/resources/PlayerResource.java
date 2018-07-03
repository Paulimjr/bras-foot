package br.com.resources;

import br.com.dto.PlayerDTO;
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
@RequestMapping(value = "/players")
public class PlayerResource {

    @Autowired
    private PlayerService playerService;

    /**
     * Save a player in Team
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
     * Find all players on Database
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
     * Find a player by ID.
     *
     * @author paulo
     * @param id the identifier of player
     * @return the player
     */
    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable final Integer id) {
        Player player = this.playerService.findById(id);
        return  ResponseEntity.ok().body(player);
    }

}
