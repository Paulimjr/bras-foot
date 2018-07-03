package br.com.resources;

import br.com.dto.PartidaDTO;
import br.com.dto.SubstituicaoDTO;
import br.com.entity.Partida;
import br.com.response.DetalhePartida;
import br.com.response.PartidaResponse;
import br.com.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/partidas")
public class PartidaResource {

    @Autowired
    private PartidaService partidaService;

    /**
     * API para inserir um Partida
     *
     * @param objDto
     * @return
     */
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody PartidaDTO objDto) {
        Partida obj = this.partidaService.fromDTO(objDto);
        this.partidaService.insert(obj);
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
    public ResponseEntity<List<PartidaDTO>> findAll() {
        List<Partida> list = this.partidaService.findAll();
        List<PartidaDTO> listDto = list.stream().map(obj -> new PartidaDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    /**
     * API para trazer a partida detalhada
     *
     * @return
     */
    @RequestMapping(value = "/{id}/detalhes", method=RequestMethod.GET)
    public ResponseEntity<?> partidaDetalhada(@PathVariable final Integer id) {
        DetalhePartida partida = this.partidaService.partidaDetalhada(id);
        return  ResponseEntity.ok().body(partida);
    }

    /**
     * API para inserir um team
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/lancargol/{id}", method=RequestMethod.PUT)
    public ResponseEntity<PartidaResponse> lancarGol(@PathVariable final Integer id,
                                                     @RequestParam(value = "timeEfetuouGol") Integer timeEfetuouGol,
                                                     @RequestParam(value = "jogadorEfetuouGol") Integer jogadorEfetuouGol,
                                                     @RequestParam(value = "numGol") Integer numGol) {
        PartidaResponse response = this.partidaService.lancarGol(id, timeEfetuouGol, jogadorEfetuouGol, numGol);
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/substituicao", method=RequestMethod.PUT)
    public ResponseEntity<?> partidaSubstituicao(@RequestBody final SubstituicaoDTO obj) {
        String response = this.partidaService.substituicao(obj);
        return  ResponseEntity.ok().body(response);
    }

    /**
     * API para consultar um Partida pelo identificador
     *
     * @author paulo
     * @param id o identificador do Partida
     * @return o Partida
     */
    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable final Integer id) {
        Partida partida = this.partidaService.findById(id);
        return  ResponseEntity.ok().body(partida);
    }

}
