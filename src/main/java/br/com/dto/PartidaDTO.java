package br.com.dto;

import br.com.entity.Partida;

import java.io.Serializable;

public class PartidaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer timeoOne;
	private Integer timeoTwo;
	private String statusPatida;
	private Integer timeVencedor;

	public PartidaDTO() {

	}

	public PartidaDTO(Partida partida) {
		this.id = partida.getId();
		this.timeoOne = partida.getTimeoOne();
		this.timeoTwo = partida.getTimeoTwo();
		this.statusPatida = partida.getStatusPatida();
		this.timeVencedor = partida.getTimeVencedor();
	}

	public PartidaDTO(Integer id, Integer timeoOne, Integer timeoTwo, String statusPatida, Integer timeVencedor) {
		this.id = id;
		this.timeoOne = timeoOne;
		this.timeoTwo = timeoTwo;
		this.statusPatida = statusPatida;
		this.timeVencedor = timeVencedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTimeoOne() {
		return timeoOne;
	}

	public void setTimeoOne(Integer timeoOne) {
		this.timeoOne = timeoOne;
	}

	public Integer getTimeoTwo() {
		return timeoTwo;
	}

	public void setTimeoTwo(Integer timeoTwo) {
		this.timeoTwo = timeoTwo;
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
}
