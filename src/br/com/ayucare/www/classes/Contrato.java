package br.com.ayucare.www.classes;

public class Contrato extends PlanoSaude {
    private String status;
    private String termos;

    public Contrato() {
    }

    public Contrato(String status, String termos) {
        this.status = status;
        this.termos = termos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTermos() {
        return termos;
    }

    public void setTermos(String termos) {
        this.termos = termos;
    }
}
