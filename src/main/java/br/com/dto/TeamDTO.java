package br.com.dto;

import br.com.entity.Team;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class TeamDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message="Preenchimento obrigatório")
	private String name;

	private String image;

	private Integer totalPontos;

	public TeamDTO() {

	}

	public TeamDTO(Team team) {
		super();
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
}
