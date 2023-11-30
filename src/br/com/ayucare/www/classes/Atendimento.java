package br.com.ayucare.www.classes;

import javax.swing.*;

public class Atendimento extends Usuario {
    private String descricao;
    private String data;
    private String hora;
    private int idade;
    private String resultadoExame;
    private String custo;

    public Atendimento() {
    }

    public Atendimento(String descricao, String data, String hora, int idade, String resultadoExame, String custo) {
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
        this.idade = idade;
        this.resultadoExame = resultadoExame;
        this.custo = custo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getResultadoExame() {
        return resultadoExame;
    }

    public void setResultadoExame(String resultadoExame) {
        this.resultadoExame = resultadoExame;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    //método para agendar consultas médicas
    public void agendarConsulta() {
        setDescricao(JOptionPane.showInputDialog("Descreva a razão da consulta:"));
        setData(JOptionPane.showInputDialog("Digite a data da consulta (DD/MM/AAAA):"));
        setHora(JOptionPane.showInputDialog("Digite a hora da consulta (HH:MM):"));
        setResultadoExame(JOptionPane.showInputDialog("Possui exames para avaliação (SIM/NÃO):"));

        int idadePaciente = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade:"));
        setIdade(idadePaciente);
        setCusto(avaliarCustoConsulta());

        JOptionPane.showMessageDialog(null, "Agendamento da consulta:\nDescrição: " + getDescricao() + "\nData: "
                + getData() + "\nHora: " + getHora() + "\nExames: " + getResultadoExame() + "\nCusto: " + getCusto());
    }

    //método privado para avaliar valor das consultas pela idade
    private String avaliarCustoConsulta() {
        int idadePaciente = getIdade();
        if (idadePaciente <= 10) {
            setCusto("A partir de R$75,00.");
        } else if (idadePaciente <= 60) {
            setCusto("A partir de R$150,00");
        } else {
            setCusto("A partir de R$280,00.");
        }

        return getCusto();
    }

    //método toString para exibir detalhes do agendamento na main
    public String toString() {
        return "Detalhes do agendamento:\n" +
                "ID: " + getId() + "\n" +
                "Descrição pré-consulta: " + getDescricao() + "\n" +
                "Data: " + getData() + "\n" +
                "Horário: " + getHora() + "\n" +
                "Exames: " + getResultadoExame() + "\n" +
                "Custo: " + getCusto() + "\n";
    }
}
