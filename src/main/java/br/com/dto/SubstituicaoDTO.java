package br.com.dto;

import java.io.Serializable;

public class SubstituicaoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer timeId;
    private Integer jogadorSaiu;
    private Integer jogadorEntrou;


    public Integer getTimeId() {
        return timeId;
    }

    public void setTimeId(Integer timeId) {
        this.timeId = timeId;
    }

    public Integer getJogadorSaiu() {
        return jogadorSaiu;
    }

    public void setJogadorSaiu(Integer jogadorSaiu) {
        this.jogadorSaiu = jogadorSaiu;
    }

    public Integer getJogadorEntrou() {
        return jogadorEntrou;
    }

    public void setJogadorEntrou(Integer jogadorEntrou) {
        this.jogadorEntrou = jogadorEntrou;
    }

    @Override
    public String toString() {
        return "SubstituicaoDTO{" +
                "timeId=" + timeId +
                ", jogadorSaiu='" + jogadorSaiu + '\'' +
                ", jogadorEntrou='" + jogadorEntrou + '\'' +
                '}';
    }
}
