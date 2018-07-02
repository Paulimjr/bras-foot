package br.com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "total_pontos")
    private Integer totalPontos;

    @Column(name = "time_id")
    private Integer timeId;

    public Player() {
    }

    public Player(Integer id, String name, Integer totalPontos, Integer timeId) {
        this.id = id;
        this.name = name;
        this.totalPontos = totalPontos;
        this.timeId = timeId;
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

    public Integer getTotalPontos() {
        return totalPontos;
    }

    public void setTotalPontos(Integer totalPontos) {
        this.totalPontos = totalPontos;
    }

    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }
}
