package br.com.dto;

public class GolsDTO {
    private Integer timeEfetuouGol;
    private Integer jogador_efetuou_gol;
    private Integer numGol;

    public GolsDTO(Integer timeEfetuouGol, Integer jogador_efetuou_gol, Integer numGol) {
        this.timeEfetuouGol = timeEfetuouGol;
        this.jogador_efetuou_gol = jogador_efetuou_gol;
        this.numGol = numGol;
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
