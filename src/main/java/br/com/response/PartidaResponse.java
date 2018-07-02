package br.com.response;

import br.com.entity.GolsPartida;
import br.com.entity.Team;

import java.util.List;

public class PartidaResponse {

    private Integer partida;
    private Team timeOne;
    private Team timeTwo;
    private String statusPatida;
    private Integer timeVencedor;
    private List<GolsPartida> gols;

    public PartidaResponse(Integer partida, Team timeOne, Team timeTwo, String statusPatida, Integer timeVencedor, List<GolsPartida> gols) {
        this.partida = partida;
        this.timeOne = timeOne;
        this.timeTwo = timeTwo;
        this.statusPatida = statusPatida;
        this.timeVencedor = timeVencedor;
        this.gols = gols;
    }

    public Integer getPartida() {
        return partida;
    }

    public void setPartida(Integer partida) {
        this.partida = partida;
    }

    public Team getTimeOne() {
        return timeOne;
    }

    public void setTimeOne(Team timeOne) {
        this.timeOne = timeOne;
    }

    public Team getTimeTwo() {
        return timeTwo;
    }

    public void setTimeTwo(Team timeTwo) {
        this.timeTwo = timeTwo;
    }

    public String getStatusPatida() {
        return statusPatida;
    }

    public void setStatusPatida(String statusPatida) {
        this.statusPatida = statusPatida;
    }

    public Integer getTimeVencedor() {
        return timeVencedor;
    }

    public void setTimeVencedor(Integer timeVencedor) {
        this.timeVencedor = timeVencedor;
    }

    public List<GolsPartida> getGols() {
        return gols;
    }

    public void setGols(List<GolsPartida> gols) {
        this.gols = gols;
    }
}
