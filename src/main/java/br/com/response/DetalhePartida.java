package br.com.response;

import br.com.dto.GolsDTO;
import br.com.entity.GolsPartida;
import br.com.entity.Team;

import java.util.List;

public class DetalhePartida {

    private Integer partida;
    private Team timeOne;
    private Team timeTwo;
    private String statusPatida;
    private Integer timeVencedor;
    private List<GolsDTO> gols;
    private int total_gols_time_one;
    private int total_gols_time_two;

    public DetalhePartida(Integer partida, Team timeOne, Team timeTwo, String statusPatida, Integer timeVencedor, List<GolsDTO> gols) {
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

    public List<GolsDTO> getGols() {
        return gols;
    }

    public void setGols(List<GolsDTO> gols) {
        this.gols = gols;
    }

    public int getTotal_gols_time_one() {
        return total_gols_time_one;
    }

    public void setTotal_gols_time_one(int total_gols_time_one) {
        this.total_gols_time_one = total_gols_time_one;
    }

    public int getTotal_gols_time_two() {
        return total_gols_time_two;
    }

    public void setTotal_gols_time_two(int total_gols_time_two) {
        this.total_gols_time_two = total_gols_time_two;
    }
}
