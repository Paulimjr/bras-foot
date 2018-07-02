package br.com.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Partida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "time_one")
    private Integer timeoOne;

    @Column(name = "time_two")
    private Integer timeoTwo;

    @Column(name = "status_partida")
    private String statusPatida;

    @Column(name = "time_vencedor")
    private Integer timeVencedor;

    public Partida() {

    }

    public Partida(Integer id, Integer timeoOne, Integer timeoTwo, String statusPatida, Integer timeVencedor) {
        this.id = id;
        this.timeoOne = timeoOne;
        this.timeoTwo = timeoTwo;
        this.statusPatida = statusPatida;
        this.timeVencedor = timeVencedor;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
