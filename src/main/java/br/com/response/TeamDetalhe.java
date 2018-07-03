package br.com.response;

import br.com.dto.PlayerDTO;
import br.com.entity.Team;

import java.util.List;

public class TeamDetalhe {

    private Integer id;
    private String name;
    private String image;
    private Integer totalPontos;
    private List<PlayerDTO> players;

    public TeamDetalhe(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.image = team.getImage();
        this.totalPontos = team.getTotalPontos();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getTotalPontos() {
        return totalPontos;
    }

    public void setTotalPontos(Integer totalPontos) {
        this.totalPontos = totalPontos;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }
}
