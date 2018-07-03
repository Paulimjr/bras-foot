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

    @Column(name = "photo")
    private String photo;

    @Column(name = "titular")
    private String titular;

    @Column(name = "posicao")
    private String posicao;

    @Column(name = "team_name")
    private String teamName;

    public Player() {
    }

    public Player(Integer id, String name, Integer totalPontos, Integer timeId, String photo, String titular, String posicao) {
        this.id = id;
        this.name = name;
        this.totalPontos = totalPontos;
        this.timeId = timeId;
        this.photo = photo;
        this.titular = titular;
        this.posicao = posicao;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public class TypeTitular {
        public static final String TITULAR_YES = "S";
        public static final String TITULAR_NO = "N";
    }

    public class Posicao {
        public static final String LATERAL = "LATERAL";
        public static final String ZAGUEIRO = "ZAGUEIRO";
        public static final String ATACANTE = "ATACANTE";
        public static final String MEIA = "MEIA";
        public static final String GOLEIRO = "GOLEIRO";
    }
}
