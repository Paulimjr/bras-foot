package br.com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "total_pontos")
    private Integer totalPontos;

    public Team() {

    }

    public Team(Integer id, String name, String image, Integer totalPontos) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.totalPontos = totalPontos;
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
