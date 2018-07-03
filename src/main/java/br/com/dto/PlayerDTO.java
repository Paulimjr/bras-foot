package br.com.dto;

import br.com.entity.Player;
import br.com.entity.Team;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class PlayerDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message="Preenchimento obrigatório")
	private String name;

	private Integer timeId;
	private Integer totalPontos;
	private String photo;
	private String titular;
	private String posicao;
	private String teamName;

	public PlayerDTO() {

	}

	public PlayerDTO(Player player) {
		super();
		this.id = player.getId();
		this.name = player.getName();
		this.timeId = player.getTimeId();
		this.totalPontos = player.getTotalPontos();
		this.photo = player.getPhoto();
		this.titular = player.getTitular();
		this.posicao = player.getPosicao();
		this.teamName = player.getTeamName();
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

	public Integer getTimeId() {
		return timeId;
	}

	public void setTimeId(Integer timeId) {
		this.timeId = timeId;
	}

	public Integer getTotalPontos() {
		return totalPontos;
	}

	public void setTotalPontos(Integer totalPontos) {
		this.totalPontos = totalPontos;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
