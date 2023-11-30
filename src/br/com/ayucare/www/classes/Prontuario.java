package br.com.ayucare.www.classes;

import javax.swing.*;

public class Prontuario extends Paciente {
    private String prescricao;
    private String observacao;
    private String anormalidades;
    private String tratamento;
    private String diagnostico;

    public Prontuario() {
    }

    public Prontuario(String prescricao, String observacao, String anormalidades, String tratamento, String diagnostico) {
        this.prescricao = prescricao;
        this.observacao = observacao;
        this.anormalidades = anormalidades;
        this.tratamento = tratamento;
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getAnormalidades() {
        return anormalidades;
    }

    public void setAnormalidades(String anormalidades) {
        this.anormalidades = anormalidades;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    //método para exibir o prontuário do paciente na main
    public void exibeProntuario(Usuario usuario) {
        String mensagem = "ID: " + getId() +
                "\nGênero: " + getGenero() +
                "\nPrescrição: " + getPrescricao() +
                "\nObservações: " + getObservacao() +
                "\nAnormalidades: " + getAnormalidades() +
                "\nTratamentos: " + getTratamento() +
                "\nDiagnósticos: " + getDiagnostico();

        JOptionPane.showMessageDialog(null, mensagem);
    }
}
