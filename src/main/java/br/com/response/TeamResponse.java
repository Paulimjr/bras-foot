package br.com.response;

import br.com.entity.Player;

import java.util.List;

public class TeamResponse {

    private Integer timeId;
    private String time;
    private String imagemTime;
    private List<Player> jogadores;
    private Integer pontos;

    public TeamResponse() {
    }

    public TeamResponse(Integer timeId, String time, String imagemTime, List<Player> jogadores, Integer pontos) {
        this.timeId = timeId;
        this.time = time;
        this.imagemTime = imagemTime;
        this.jogadores = jogadores;
        this.pontos = pontos;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImagemTime() {
        return imagemTime;
    }

    public void setImagemTime(String imagemTime) {
        this.imagemTime = imagemTime;
    }

    public List<Player> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Player> jogadores) {
        this.jogadores = jogadores;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }
}
