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

	public PlayerDTO() {

	}

	public PlayerDTO(Player player) {
		super();
		this.id = player.getId();
		this.name = player.getName();
		this.timeId = player.getTimeId();
		this.totalPontos = player.getTotalPontos();
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
}
