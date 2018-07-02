package br.com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class GolsPartida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "partida_id")
    private Integer partidaId;

    @Column(name = "time_efetuou_gol")
    private Integer timeEfetuouGol;

    @Column(name = "jogador_efetuou_gol")
    private Integer jogador_efetuou_gol;

    @Column(name = "num_gol")
    private Integer numGol;

    public GolsPartida() {

    }

    public GolsPartida(Integer id, Integer partidaId, Integer timeEfetuouGol, Integer jogador_efetuou_gol, Integer numGol) {
        this.id = id;
        this.partidaId = partidaId;
        this.timeEfetuouGol = timeEfetuouGol;
        this.jogador_efetuou_gol = jogador_efetuou_gol;
        this.numGol = numGol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(Integer partidaId) {
        this.partidaId = partidaId;
    }

    public Integer getTimeEfetuouGol() {
        return timeEfetuouGol;
    }

    public void setTimeEfetuouGol(Integer timeEfetuouGol) {
        this.timeEfetuouGol = timeEfetuouGol;
    }

    public Integer getJogador_efetuou_gol() {
        return jogador_efetuou_gol;
    }

    public void setJogador_efetuou_gol(Integer jogador_efetuou_gol) {
        this.jogador_efetuou_gol = jogador_efetuou_gol;
    }

    public Integer getNumGol() {
        return numGol;
    }

    public void setNumGol(Integer numGol) {
        this.numGol = numGol;
    }
}
