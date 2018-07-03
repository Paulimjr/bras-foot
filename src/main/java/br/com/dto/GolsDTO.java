package br.com.dto;

public class GolsDTO {

    private String timeEfetuouGol;
    private String jogadorEfetuouGol;
    private Integer numGol;

    public String getTimeEfetuouGol() {
        return timeEfetuouGol;
    }

    public void setTimeEfetuouGol(String timeEfetuouGol) {
        this.timeEfetuouGol = timeEfetuouGol;
    }

    public String getJogadorEfetuouGol() {
        return jogadorEfetuouGol;
    }

    public void setJogadorEfetuouGol(String jogadorEfetuouGol) {
        this.jogadorEfetuouGol = jogadorEfetuouGol;
    }

    public Integer getNumGol() {
        return numGol;
    }

    public void setNumGol(Integer numGol) {
        this.numGol = numGol;
    }
}
